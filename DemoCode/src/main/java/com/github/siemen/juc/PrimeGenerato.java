package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-06-05.
 */

import com.github.siemen.juc.annotation.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 素数生成器
 * 通过volatile标志位设置取消状态
 */
public class PrimeGenerato implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primeList = new ArrayList<>();

    private volatile boolean canceled;


    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!canceled){
            p = p.nextProbablePrime();
            synchronized (this){
                primeList.add(p);
            }
        }
    }

    public void cancel(){
        this.canceled = true;
    }

    public synchronized List<BigInteger> getPrimeList(){
        return  new ArrayList<>(this.primeList);
    }

    /**
     * 运行1秒后设置取消标志
     * 设置点和检查点有时间差
     * */
    public static void main(String[] args) throws InterruptedException {
        PrimeGenerato primeGenerato = new PrimeGenerato();
        new Thread(primeGenerato).start();
        try {
            SECONDS.sleep(1);
        }finally {
            primeGenerato.cancel();
        }

        primeGenerato.getPrimeList().forEach(System.out::println);
    }
}
