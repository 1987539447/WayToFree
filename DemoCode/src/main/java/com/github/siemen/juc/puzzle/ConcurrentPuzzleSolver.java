package com.github.siemen.juc.puzzle;
/**
 * Created by Zhan on 2017-06-06.
 */

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import com.github.siemen.juc.puzzle.SequentialPuzzleSolver.Node;

/**
 * 并发谜题解决方案
 */
public class ConcurrentPuzzleSolver<P,M> {

    /**puzzle实现*/
    private final Puzzle<P,M> puzzle;
    /**并发执行线程池*/
    private final ExecutorService exec;
    /**并发map,存储已处理位置*/
    private final ConcurrentHashMap<P,Boolean> seen;
    /**带返回值闭锁，控制只查找一个解决方案*/
    final ValueLatch<Node<P,M>> solution = new ValueLatch<>();


    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentHashMap<P, Boolean> seen) {
        this.puzzle = puzzle;
        this.exec = exec;
        this.seen = seen;
    }

    /**初始化位置并搜索答案*/
    public List<M> solve() throws InterruptedException {
        try {
            P p = puzzle.initialPosition();
            exec.execute(newTask(p,null,null));//从初始化点提交任务
            Node<P,M> solNode = solution.getValue();//阻塞直到找到结果
            return solNode == null ? null : solNode.asMoveList();
        }finally {
            exec.shutdown();//关闭线程池
        }
    }

    private Runnable newTask(P p, M m, Node<P,M> pre) {
        return new SolverTask(p,m,pre);
    }

    /**独立任务实现*/
    private class SolverTask extends Node<P,M> implements Runnable {

        SolverTask(P pos, M move, Node<P, M> pre) {
            super(pos, move, pre);
        }

        @Override
        public void run() {

            if(solution.isSet() || seen.putIfAbsent(pos,true) != null){//已经找到答案或者已经搜索过直接返回
                return;
            }
            if(puzzle.isGoal(pos)){//找到答案，设置保存
                solution.setValue(new Node<P, M>(pos,move,pre));
            }else{//没找到答案，循环所有下一步位置，提交新任务
                for (M m : puzzle.legalMoves(pos)) {
                    exec.execute(newTask(puzzle.move(pos,m),m,this));
                }
            }
        }
    }
}
