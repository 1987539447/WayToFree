package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-30.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过Lock实现信号量
 * lock保护可用许可数，无许可可用时在条件等待，释放需求可时通知
 */
public class SemaphoreOnLock {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition permitsAvailable = lock.newCondition();
    private int permits;

    public SemaphoreOnLock(int permits) {
        this.permits = permits;
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <=0 ){
                permitsAvailable.await();
            }
            --permits;
        }finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            ++permits;
            permitsAvailable.signal();
        }finally {
            lock.unlock();
        }
    }
}
