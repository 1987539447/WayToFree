package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-15.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过锁 模拟AtomicInteger
 */
public class AtomicIntegerWithLock {

    private static int staticValue;
    private  int value;

    private Lock lock = new ReentrantLock();

    public AtomicIntegerWithLock(){
        super();
    }

    public AtomicIntegerWithLock(int value){
        this.value = value;
    }

    public final int get(){
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();
        }
    }

    public final void set(int newValue){
        lock.lock();
        try {
            this.value = newValue;
        }finally {
            lock.unlock();
        }
    }

    public final int incrementAndGet(){
        lock.lock();
        try {
            return ++this.value;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final int max = 10;
        final int loopCount = 100000;
        long costTime = 0;

        for (int i = 0; i < max; i++) {
            long start1 = System.nanoTime();
            final AtomicIntegerWithLock value1 = new AtomicIntegerWithLock(0);
            Thread[] threads = new Thread[max];
            for (int j = 0; j < max; j++) {
                threads[j] = new Thread(){
                    @Override
                    public void run() {
                        for (int k = 0; k < loopCount; k++) {
                            value1.incrementAndGet();
                        }
                    }
                };
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1 - start1);
        }

        System.out.println("costTime1:"+costTime);

        costTime = 0;
        final Object lock = new Object();
        for (int i = 0; i < max; i++) {
            long start1 = System.nanoTime();
            Thread[] threads = new Thread[max];
            for (int j = 0; j < max; j++) {
                threads[j] = new Thread(){
                    @Override
                    public void run() {
                        for (int k = 0; k < loopCount; k++) {
                            increment();
/*                            synchronized (lock){
                                ++staticValue;
                            }*/
                        }
                    }
                };
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1 - start1);
        }
        System.out.println("costTime2:"+costTime);
    }

    public static synchronized int increment(){
        return ++staticValue;
    }
}
