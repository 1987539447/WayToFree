package com.github.siemen.tracker;
/**
 * Created by Zhan on 2017-06-20.
 */

import com.github.siemen.annotation.NotThreadSafe;

/**
 * 可变位置类
 */
@NotThreadSafe
public class MutablePoint {
    public int x,y;
    public MutablePoint(){
        x = 0;
        y = 0;
    }
    public MutablePoint(MutablePoint point){
        this.x = point.x;
        this.y = point.y;

    }
}
