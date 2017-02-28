package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 * 接口默认方法
 */
public interface Formula {
    double calculate(int i);
    default double sqrt(int i){
        return Math.sqrt(i);
    }
}
