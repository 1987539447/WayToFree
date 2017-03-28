package com.github.siemen.thread;

import com.github.siemen.thread.lock.Bank;

/**
 * Created by Zhan on 2017/3/21 0021.
 */
public class TransferRunable implements Runnable {

    private  Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunable(Bank bank, int from, double maxAmount){

        this.bank = bank;
        this.fromAccount = from;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        while (true){
            try {
                int toAccount = (int) (bank.getSize()*Math.random());
                double amount = maxAmount * Math.random();
                //bank.transfer(fromAccount,toAccount,amount);//调用使用lock condition方法
                bank.syncTransfer(fromAccount,toAccount,amount);//调用sync方法
                Thread.sleep((long) (DELAY * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
