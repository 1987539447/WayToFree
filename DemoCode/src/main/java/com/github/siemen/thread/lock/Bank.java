package com.github.siemen.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Zhan on 2017/3/21 0021.
 */
public class Bank {
    private Lock bankLock;
    private double[] accounts;
    private int size;
    private Condition sufFunds;

    /**
     * 银行账户初始化，初始化锁和条件
     * */
    public Bank(int size,double initBalance){
        accounts = new double[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            accounts[i] = initBalance;
        }
        bankLock = new ReentrantLock();
        sufFunds = bankLock.newCondition();
    }

    /**
    *账户金额转移
     * 整个方法使用lock并发
     * 当转出账户金额不足时，条件等待
     * 转移后触发一次通知
     */
    public void transfer(int from,int to,double amount){
        bankLock.lock();
        try{
            while (accounts[from] < amount){
                sufFunds.await();
            }
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ",amount,from,to);
            accounts[to] += amount;
            System.out.printf(" Total Banlance : %10.2f%n",getTotalBalance());
            sufFunds.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bankLock.unlock();
        }
    }

    /**
     *账户金额转移
     * 整个方法使用lock并发
     * 当转出账户金额不足时，条件等待
     * 转移后触发一次通知
     */
    public synchronized void syncTransfer(int from,int to,double amount) throws InterruptedException {
            while (accounts[from] < amount){
                wait();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ",amount,from,to);
            accounts[to] += amount;
            System.out.printf(" Total Banlance : %10.2f%n",getTotalBalance());
            notifyAll();
    }

    /**
     * 计算所有账户总额
     * */
    public double getTotalBalance(){
        bankLock.lock();
        try{
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

    /**
     * 计算所有账户总额
     * */
    public synchronized double getTotalBalanceSync(){
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
    }

    public int getSize(){
        return  this.size;
    }
}
