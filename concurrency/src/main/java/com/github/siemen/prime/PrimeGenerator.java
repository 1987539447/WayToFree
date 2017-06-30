package com.github.siemen.prime;
/**
 * Created by Zhan on 2017-06-23.
 */

import com.github.siemen.annotation.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 可取消的素数生成器
 * 通过volatile的状态标志位来控制是否取消-停止
 * 提供开放的取消方法
 */
public class PrimeGenerator implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primeList = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {

        BigInteger p = BigInteger.ONE;
        while (!cancelled){
            p = p.nextProbablePrime();
            synchronized (this){
                primeList.add(p);
            }
        }
    }

    public void cancel(){
        this.cancelled = true;
    }

    public synchronized List<BigInteger> getPrimes(){
        return new ArrayList<>(this.primeList);
    }

    public static List<BigInteger> aSecondofPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }finally {
            generator.cancel();
        }
        return generator.getPrimes();
    }

    public static void main(String[] args) throws InterruptedException {
        List<BigInteger> primeList = PrimeGenerator.aSecondofPrimes();
        for (BigInteger bigInteger : primeList) {
            System.out.println(bigInteger);
        }
    }
}
