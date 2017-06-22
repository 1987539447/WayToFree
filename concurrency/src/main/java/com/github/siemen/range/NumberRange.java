package com.github.siemen.range;
/**
 * Created by Zhan on 2017-06-21.
 */

import com.github.siemen.annotation.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限定范围值域
 * 约束：开始值不能大于结束值
 * 实现非线程安全：虽然使用了AtomicInter保证操作的原子性，
 * 但无法同时保证lower和upper并发操作原子性
 * 不变约束涉及多个变量
 *
 */
@NotThreadSafe
public class NumberRange {

    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        //不安全的检查再运行
        if(i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to"+i+">upper "+upper.get());
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        //不安全的检查再运行
        if(i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to"+i+"< lower "+lower.get());
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
