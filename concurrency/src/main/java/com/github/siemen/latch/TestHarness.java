package com.github.siemen.latch;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.util.concurrent.CountDownLatch;

/**
 * 测试闭锁使用
 * 通过使用值为1的闭锁等待所有线程准备好
 * 通过与线程数相同闭锁等待线程全部执行完毕
 */
public class TestHarness {

    public long timeTask(int nThreads,final Runnable task) throws InterruptedException{

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        startGate.await();//等待所有线程创建完成
                        try{
                            task.run();
                        }finally {
                            endGate.countDown();//减少闭锁
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();//放开-所有线程运行
        endGate.await();//等待所有线程完成
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException{
        TestHarness harness = new TestHarness();
        long time = harness.timeTask(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("----I'm working---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println( e.getMessage());;
                }
            }
        });
        System.out.println("--total working nanos--"+ time);
    }
}
