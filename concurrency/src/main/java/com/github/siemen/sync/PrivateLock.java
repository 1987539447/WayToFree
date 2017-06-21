package com.github.siemen.sync;
/**
 * Created by Zhan on 2017-06-19.
 */

/**
 * 使用私有锁
 * 防止客户端拿到锁进行错误的使用
 */
public class PrivateLock {

    private final Object myLock = new Object();

    Widget widget;

    public void someWork(){
        synchronized (myLock){
            //widget 同步修改
            System.out.println(widget);
        }
    }

    private class Widget {
    }
}
