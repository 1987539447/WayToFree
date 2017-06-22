package com.github.siemen.tracker;
/**
 * Created by Zhan on 2017-06-21.
 */

import com.github.siemen.annotation.ThreadSafe;

/**
 * 可变的线程安全Point类
 * 对set 和get使用同步
 * 并保证x,y同时设置和返回
 */
@ThreadSafe
public class SafePoint {

    private int x;
    private int y;

    public SafePoint(int[] point){
        this.x = point[0];
        this.y = point[1];
    }

    public SafePoint(SafePoint point){
        this(point.get());
    }

    public SafePoint(int x,int y){
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{this.x,this.y};
    }

    //x,y必须同时设置，否则可能出现错误位置
    public synchronized void set(int x,int y){
        this.x = x;
        this.y = y;
    }
}
