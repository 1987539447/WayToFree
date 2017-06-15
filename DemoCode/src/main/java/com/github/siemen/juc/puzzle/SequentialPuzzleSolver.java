package com.github.siemen.juc.puzzle;
/**
 * Created by Zhan on 2017-06-06.
 */

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 顺序谜题解决方案
 */
public class SequentialPuzzleSolver<P,M> {

    /**谜题实现，构造传入*/
    private final Puzzle<P,M> puzzle;
    /**已检查位置集合，避免重复检查*/
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }


    /**初始化位置，开始搜索*/
    public List<M> solve(){
        P pos = puzzle.initialPosition();
        return search(new Node<P,M>(pos,null,null));
    }

    /**
     * 顺序搜索
     * 从初始节点开始，递归搜索直到找到一个解决方案即返回
     * */
    private List<M> search(Node<P, M> node) {
        if(!seen.contains(node.pos)){//检查是否已搜索
            seen.add(node.pos);
            if(puzzle.isGoal(node.pos)){//当前节点是否到达目标
                return node.asMoveList();
            }
            for (M m : puzzle.legalMoves(node.pos)) {//取可用move,循环执行
                P pos = puzzle.move(node.pos,m);//移动到新位置，递归搜索
                Node<P,M> child = new Node<>(pos,m,node);
                List result = search(child);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
    }


    /**
     * 解决框架链接节点
     * */
    @Immutable
    static class Node<P,M>{
        /**当前节点位置*/
        final P pos;
        /**移动到pos的操作*/
        final M move;
        /**移动前一个节点*/
        final Node<P,M> pre;

        Node(P pos, M move, Node<P, M> pre) {
            this.pos = pos;
            this.move = move;
            this.pre = pre;
        }

        /**
         * 返回解决方案
         * */
        List<M> asMoveList(){
            List<M> solution = new LinkedList<>();
            for (Node<P,M> n = this; n.move != null ; n = n.pre) {
                solution.add(0,n.move);//向前添加到头部
            }
            return  solution;
        }
    }
}
