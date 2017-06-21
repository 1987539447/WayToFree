package com.github.siemen.tracker;
/**
 * Created by Zhan on 2017-06-20.
 */

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * 不可变位置存储类
 */
@Immutable
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
