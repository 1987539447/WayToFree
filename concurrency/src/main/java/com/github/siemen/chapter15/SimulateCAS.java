package com.github.siemen.chapter15;
/**
 * Created by Zhan on 2017-06-30.
 */

import com.github.siemen.annotation.GuardedBy;

/**
 * 模拟CAS操作
 * 原子操作
 * 先比较再交换-设置
 *
 */
public class SimulateCAS {
    @GuardedBy("this")
    private int value;

    public synchronized int get(){
        return this.value;
    }

    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = this.value;
        if(oldValue == expectedValue){
            this.value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue,int newValue) {
        return expectedValue == compareAndSwap(expectedValue,newValue);
    }
}
