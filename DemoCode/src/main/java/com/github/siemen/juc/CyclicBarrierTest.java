package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-17.
 */


import java.util.concurrent.*;

/**
 * CyclicBarrier测试
 */
public class CyclicBarrierTest {

    final CyclicBarrier barrier;
    final int MAX_TASK;


    public CyclicBarrierTest(int maxTask) {
        Runnable task = () -> System.out.println("--------gate open------");
        barrier = new CyclicBarrier(maxTask + 1,task);
        MAX_TASK = maxTask;
    }

    public void doWork(final Runnable work){
        new Thread(){
            @Override
            public void run() {
                work.run();
                try {
                    int index = barrier.await();
                    doWithIndex(index);
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }.start();
    }

    private void doWithIndex(int index) {
        if(index == MAX_TASK/3){
            System.out.println("Left 30%....");
        }else if(index == MAX_TASK/2){
            System.out.println("Left 50%.....");
        }else if(index == 0){
            System.out.println("Run over......");
        }
    }

    public void waitForNext(){
        try {
            doWithIndex(barrier.await());
        } catch (InterruptedException e) {
            return;
        } catch (BrokenBarrierException e) {
            return;
        }
    }

    public static void main(String[] args) {
        final  int count = 10;
        CyclicBarrierTest test = new CyclicBarrierTest(count);
        for (int i = 0; i < 100; i++) {
            test.doWork(new Runnable() {
                @Override
                public void run() {
                    System.out.println("..........action.....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            if((i+1) % count == 0){
                test.waitForNext();
            }
        }
    }


}
