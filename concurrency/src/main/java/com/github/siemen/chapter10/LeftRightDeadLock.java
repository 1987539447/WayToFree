package com.github.siemen.chapter10;
/**
 * Created by Zhan on 2017-06-29.
 */

/**
 * 简单的顺序死锁
 * 以不同的顺序获取不同的锁，导致两个线程相互等待对方释放锁
 */
public class LeftRightDeadLock {

    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight(){
        synchronized (left){
            synchronized (right){
                doSometing();
            }
        }
    }

    public void rightLeft(){
        synchronized (right){
            synchronized (left){
                doSometing();
            }
        }
    }

    private void doSometing() {
        System.out.println("--------woking-----");
    }
}
