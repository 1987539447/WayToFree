package com.github.siemen.visibility;
/**
 * Created by Zhan on 2017-06-19.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数绵羊-volatile
 * valatile保证变量的内存可见性，但不能保证原子性
 */
public class CountSheep {

    private volatile boolean asleep;
    private AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        CountSheep countSheep = new CountSheep();
        System.out.println("------start to countSheep-----");
        countSheep.countSheep();
        Thread.sleep(10000);
        System.out.println("after 10s--sheeps:"+countSheep.count.get());
        Thread.sleep(10000);
        countSheep.asleep = true;
        System.out.println("another 10s asleep:"+countSheep.asleep+"--sheeps:"+countSheep.count.get());
    }

    public void countSheep(){
        final Runnable countSheep = new Runnable() {
            public void run() {
                while (!asleep){
                    count.incrementAndGet();
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(countSheep).start();
        }
    }
}
