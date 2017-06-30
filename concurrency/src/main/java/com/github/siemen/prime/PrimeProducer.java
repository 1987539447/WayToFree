package com.github.siemen.prime;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 通过中断取消任务
 * 可响应中断的阻塞操作，接收中断信号而取消
 */
public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;


    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try{
            BigInteger p = BigInteger.ONE;
            while(Thread.currentThread().isInterrupted()){
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        interrupt();
    }
}
