package com.github.siemen.sync;
/**
 * Created by Zhan on 2017-06-19.
 */

import com.github.siemen.annotation.GuardedBy;

/**
 * 使用java监视器模式-synchronized
 * 通过对象内部锁保护
 */
public class Counter {
    @GuardedBy("this")
    private long value = 0;

    public synchronized long getValue(){
        return value;
    }

    public synchronized long increment(){
        if(value == Long.MAX_VALUE){
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
