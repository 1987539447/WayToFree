package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-04-28.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用CountdownLatch
 * 计数等待
 */
public class CountdownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable action = new Runnable() {
            @Override
            public void run() {
                System.out.println("---action----");
            }
        };
        System.out.println("---execute time--"+time(executor,3,action));
        executor.shutdown();
    }

    public static long time(Executor executor,int concurrency,final Runnable action) throws InterruptedException{

        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("---0--");
                    ready.countDown();//准备计数-1，全部减完则通知ready.await
                    try {
                        start.await();//等待start-1 然后继续执行
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        done.countDown();//完成计数-1
                    }
                }
            });
        }
        System.out.println("---1--");
        ready.await();//准备等待 -- 等所有线程创建
        long startNanos = System.nanoTime();
        start.countDown();//执行-1， 触发所有线程执行
        System.out.println("---2--");
        done.await();//等待所有线程完成
        System.out.println("---3--");
        //((ExecutorService)executor).shutdown();
        return System.nanoTime() - startNanos;
    }
}
