package com.github.siemen.prime;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 不可靠取消，阻塞生产者
 * 素数生产者可能正被阻塞，导致无法轮询到取消标志
 */
public class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            BigInteger p = BigInteger.ONE;
            while (!cancelled){
                queue.put(p = p.nextProbablePrime());//队列满时阻塞，无法获取到取消标志
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        this.cancelled = true;
    }

    void consumerPrimes() throws InterruptedException {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
        producer.start();
        try{
            while(needMore()){
                consume(queue.take());
            }
        }finally {
            producer.cancel();
        }
    }


    private void consume(BigInteger take) {

    }

    private boolean needMore() {
        return false;
    }
}
