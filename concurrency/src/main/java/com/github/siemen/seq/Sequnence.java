package com.github.siemen.seq;
/**
 * Created by Zhan on 2017-06-16.
 */

import com.github.siemen.annotation.GuardedBy;

/**
 * 线程安全序列生成器
 * 通过synchronized内部锁保护同步
 */
public class Sequnence {
    @GuardedBy("this")
    private int value;

    public synchronized int getValue(){
        return value++;
    }
}
