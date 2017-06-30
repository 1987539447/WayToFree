package com.github.siemen.chapter13;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 显式锁
 * 显式lock和unlock，通过trylock避免死锁
 */
public class UseLock {


    /**
     * 通过显式锁避免顺序死锁问题
     **/
    public boolean transferMoney(Account fromAccount, Account toAccount, DollarAmount amount, long timeout, TimeUnit unit) throws InterruptedException {
        long fixedDelay = getFixedDelayComponentNanos(timeout,unit);
        long randMod = getRandomDelayModulusNanos(timeout,unit);
        long stopTime = System.nanoTime() + unit.toNanos(timeout);//方法执行截止时间
        Random rnd = new Random();
        while (true){
            if(fromAccount.lock.tryLock()){
                try{
                    if(toAccount.lock.tryLock()){
                        try{
                            if(fromAccount.getBalance().compareTo(amount)<0){
                                throw new IllegalStateException("not enought money");
                            }else{
                                fromAccount.debit(amount);
                                toAccount.credit(amount);
                            }
                        }finally {
                            toAccount.lock.unlock();
                        }
                    }
                }finally {
                    fromAccount.lock.unlock();
                }
            }
            if(System.nanoTime() < stopTime){//??
                return false;
            }

            NANOSECONDS.sleep(fixedDelay + rnd.nextLong() % randMod);//随机休眠避免活锁
        }

    }


    ReentrantLock lock = new ReentrantLock();

    /**
     * 设置时间的锁获取
     * */
    public boolean trySendOnSharedLine(String msg,long timeout,TimeUnit unit) throws InterruptedException {
        long nanosLock = unit.toNanos(timeout) - estimatedNanosToSend(msg);

        if(!lock.tryLock(nanosLock,NANOSECONDS)){
            return false;
        }
        try {
            return sendOnShardLine(msg);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 可中断锁获取
     * */
    private boolean sendOnShardLine(String msg) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            return cancellableSendOnSharedLine(msg);
        }finally {
            lock.unlock();
        }
    }

    private boolean cancellableSendOnSharedLine(String msg) {
        return false;
    }

    private long estimatedNanosToSend(String msg) {
        return 0;//消息发送耗时
    }


    private long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
        return 0;//获得随机延迟时间
    }

    private long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
        return 0;//超时时间转化为纳秒
    }

    private class Account {
        public ReentrantLock lock;

        public Comparable<DollarAmount> getBalance() {
            return null;
        }

        public void debit(DollarAmount amount) {

        }

        public void credit(DollarAmount amount) {

        }
    }

    private class DollarAmount {
    }
}
