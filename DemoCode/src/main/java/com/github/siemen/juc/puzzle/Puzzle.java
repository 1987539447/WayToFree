package com.github.siemen.juc.puzzle;

import java.util.Set;

/**
 * Created by Zhan on 2017-06-06.
 * 谜题接口抽象
 */
public interface Puzzle<P,M> {
    /**
     * 初始化起始位置
     * */
    P initialPosition();
    /**
     * position是否到达目标位置
     * */
    boolean isGoal(P position);
    /**
     * position可用后续节点
     * */
    Set<M> legalMoves(P position);
    /**
     * 从position做一次move
     * */
    P move(P position,M move);
}
