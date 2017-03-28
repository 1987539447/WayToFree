package com.github.siemen.thread;

import com.github.siemen.thread.lock.Bank;

/**
 * Created by Zhan on 2017/3/21 0021.
 */
public class BankTransferTest {
    public static final int MAX_ACCOUNT = 100;
    public static final double INIT_BALANCE = 1000;
    public static void main(String[] args) {
        Bank bank = new Bank(MAX_ACCOUNT,INIT_BALANCE);
        for (int i = 0; i < MAX_ACCOUNT; i++) {
            TransferRunable tran = new TransferRunable(bank,i,INIT_BALANCE);
            Thread thread = new Thread(tran);
            thread.start();
        }
    }
}
