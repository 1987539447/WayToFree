package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-30.
 */

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 通过AQS实现的二元闭锁
 * 私有类继承AQS，并根据需要实现release acquire相关方法
 * 根据AQS 的state实现自己的语义
 */
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void signal(){
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireInterruptibly(0);
    }


    private class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryRelease(int arg) {
            setState(1);//打开闭锁
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return (getState() == 1) ? 1 : -1;//state 为1 则闭锁为打开状态
        }
    }
}
