package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用显式条件的有限缓存
 * 在特定条件上等待和通知
 */
public class ConditionBoundedBuffer<T> {

    protected final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final int BUFFER_SIZE = 100;
    private final T[] buf = (T[]) new Object[BUFFER_SIZE];
    private int count;
    private int tail;
    private int head;

    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == buf.length){//等待非空信号，条件满足后再检测一次
                notFull.await();
            }
            buf[tail] = t;
            if(++tail == buf.length){
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            T t = buf[head];
            buf[head] = null;
            if(++head == buf.length){
                head = 0;
            }
            --count;
            notFull.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

}
