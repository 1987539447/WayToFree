package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-29.
 */

/**
 * 使用条件队列
 * 不满足先验条件时执行wait,等待条件满足通知
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()){
            wait();
        }
        boolean empty = isEmpty();//仅原来为空时才进行通知
        doPut(v);
        if(empty){
            notifyAll();
        }

    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()){
            wait();
        }
        boolean full = isFull();//仅原来为满时才通知
        V v = doTake();
        if(full) {
            notifyAll();
        }
        return v;
    }
}
