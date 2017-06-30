package com.github.siemen.chapter10;
/**
 * Created by Zhan on 2017-06-29.
 */

/**
 * 动态顺序死锁-银行账户转移
 */
public class Bank {

    //加时赛锁，出现计算顺序相同时竞争该锁
    private static final Object tieLock = new Object();

    /**加锁的顺序相同，但代表的对象可能相反，A-B，B-A*/
    public void transferMoney(Acount fromAcount,Acount toAcount,DollarAmount amount){
        synchronized (fromAcount){
            synchronized (toAcount){
                if(fromAcount.getBalance().compareTo(amount)<0){
                    throw new IllegalStateException("not enought money");
                }else{
                    fromAcount.debit(amount);
                    toAcount.credit(amount);
                }
            }
        }
    }

    public void transferMoneyCTL(Acount fromAcount,Acount toAcount,DollarAmount amount){

        class Helper {
            public void transfer(){
                if(fromAcount.getBalance().compareTo(amount)<0){
                    throw new IllegalStateException("not enought money");
                }else{
                    fromAcount.debit(amount);
                    toAcount.credit(amount);
                }
            }
        }

        //计算并比较两个账户对象的hash，按顺序加锁
        int fromHash = System.identityHashCode(fromAcount);
        int toHash = System.identityHashCode(toAcount);

        if(fromHash > toHash){
            synchronized (fromAcount){
                synchronized (toAcount){
                    new Helper().transfer();
                }
            }
        }else if(toHash > fromHash){
            synchronized (toAcount){
                synchronized (fromAcount){
                    new Helper().transfer();
                }
            }
        }else{//出现冲突时，竞争加时赛锁
            synchronized (tieLock){
                synchronized (fromAcount){
                    synchronized (toAcount){
                        new Helper().transfer();
                    }
                }
            }
        }
    }






    private class Acount {
        public DollarAmount getBalance() {
            return null;
        }

        public void debit(DollarAmount amount) {

        }

        public void credit(DollarAmount amount) {

        }
    }

    private class DollarAmount {
        public int compareTo(DollarAmount amount) {
            return 0;
        }
    }
}
