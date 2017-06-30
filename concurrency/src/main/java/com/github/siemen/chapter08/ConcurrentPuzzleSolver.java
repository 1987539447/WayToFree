package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

/**
 * 并发版本谜题解决
 * 通过并发map存储已处理位置，通过putIfAbsent返回值判断是否处理过
 * 通过executor递归提交任务，找到答案即设置到ValueLath
 * 从ValueLatch阻塞等待某个线程找到答案
 * 如果不存在答案，则程序一直阻塞
 */
public class ConcurrentPuzzleSolver<P,M> {

    private final Puzzle<P,M> puzzle;
    private final ExecutorService executor;
    private final ConcurrentMap<P,Boolean> seen;
    final ValueLatch<Node<P,M>> solution = new ValueLatch<>();

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService executor) {
        this.puzzle = puzzle;
        this.executor = executor;
        this.seen = new ConcurrentHashMap<>();
    }

    public List<M> solve() throws InterruptedException {
        try {
            P p = this.puzzle.initialPosition();
            executor.submit(newTask(p,null,null));//提交最初任务
            Node<P,M> solNode = solution.getValue();//阻塞等待结果
            return solNode == null ? null : solNode.aslist();
        }finally {
            executor.shutdown();
        }
    }

    //增加一层 以实现不同的搜索任务
    protected Runnable newTask(P p,M m,Node<P,M> pre){
        return new SolveTask(p,m,pre);
    }


    /**
     * 解决方案节点：当前点+到当前点的移动+前一个结点
     * 找到解决方案后，从后向前获得移动链
     */
    static class Node<P,M> {
        final P position;
        final M move;
        final Node<P,M> pre;

        Node(P p, M move, Node<P, M> pre) {
            this.position = p;
            this.move = move;
            this.pre = pre;
        }

        List<M> aslist(){
            List<M> solution = new LinkedList<>();
            for (Node<P,M> node = this; node.move != null ; node = node.pre) {
                solution.add(node.move);
            }
            return solution;
        }
    }

    class SolveTask extends Node<P,M> implements Runnable {

        SolveTask(P p, M move, Node<P, M> pre) {
            super(p, move, pre);
        }

        @Override
        public void run() {
            if(solution.isSet() || seen.putIfAbsent(position,true) != null){//还没找到答案或已处理过
                return;
            }
            if(puzzle.isGoal(position)){
                solution.setValue(this);
            }else{
                for (M m : puzzle.legalMove(position)) {//提交并发子任务
                    executor.submit(newTask(puzzle.move(position,m),m,this));
                }
            }
        }
    }
}
