package com.github.siemen.chapter08;

import java.util.Set;

/**
 * Created by Zhan on 2017-06-29.
 * 迷宫接口：
 * 初始化位置-是否解决-可选下一步移动-移动
 */
public interface Puzzle<P,M> {
    P initialPosition();
    boolean isGoal(P position);
    Set<M> legalMove(P position);
    P move(P position,M move);
}
