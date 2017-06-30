package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 顺序化解决方案
 * 获得一个方案即返回
 * 循环下一步结点，依次递归检测是否已解决
 */
public class SequentialPuzzleSolver<P,M> {

    private final Puzzle<P,M> puzzle;
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> solve(){
        P p = this.puzzle.initialPosition();
        return search(new Node<P,M>(p,null,null));
    }

    private List<M> search(Node<P,M> node) {
        if(!seen.contains(node.position)){
            seen.add(node.position);
            if(this.puzzle.isGoal(node.position)){
                return node.aslist();
            }
            for (M move : this.puzzle.legalMove(node.position)) {
                P p = this.puzzle.move(node.position,move);
                Node<P,M> child = new Node<>(p,move,node);
                List<M> result = search(child);
                if(result != null){
                    return result;
                }
            }
        }
        return null;
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
}
