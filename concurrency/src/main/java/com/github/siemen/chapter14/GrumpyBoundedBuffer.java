package com.github.siemen.chapter14;
/**
 * Created by Zhan on 2017-06-29.
 */

/**
 * 有限缓存简单实现-先验条件不满足抛出异常
 * 客户端使用时需要考虑处理异常,不抛出异常返回处理状态同样需要客户端判断处理
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws IllegalStateException{
        if(isFull()){
            throw new IllegalStateException("buffer is full");
        }
        doPut(v);
    }

    public synchronized V take() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("buffer is empty");
        }
        return doTake();
    }

}
