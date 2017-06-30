package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-29.
 */

/**
 * 有限缓存实现基类
 * 提供基础操作
 */
public abstract class BaseBoundedBuffer<V> {

    private final V[] buf;
    private int head;
    private int tail;
    private int count;

    protected BaseBoundedBuffer(int capacity) {
        this.buf = (V[]) new Object[capacity];
    }

    protected synchronized final void doPut(V v){
        buf[tail] = v;
        if(++tail == buf.length){//到尾后从头开始
            tail = 0;
        }
        ++count;//元素计数
    }

    protected synchronized final V doTake(){
        V value = buf[head];
        buf[head] = null;
        if(++head == buf.length){
            head = 0;
        }
        --count;//元素计数
        return value;
    }

    protected synchronized final boolean isFull(){
        return count == buf.length;
    }

    protected synchronized final boolean isEmpty(){
        return count == 0;
    }
}
