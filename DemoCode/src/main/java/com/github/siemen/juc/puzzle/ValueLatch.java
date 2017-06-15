package com.github.siemen.juc.puzzle;
/**
 * Created by Zhan on 2017-06-06.
 */

import com.github.siemen.juc.annotation.GuardedBy;
import com.github.siemen.juc.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;

/**
 * 可携带结果的闭锁
 * 用于在找到一个解决方案则结束搜索
 */
@ThreadSafe
public class ValueLatch<T> {

    /**存储解决方案*/
    @GuardedBy("this")
    private T value = null;

    /**闭锁开关*/
    private final CountDownLatch done = new CountDownLatch(1);

    public boolean isSet(){
        return done.getCount() == 0;
    }

    public synchronized void setValue(T value){
        if(!isSet()){
            this.value = value;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this){
            return this.value;
        }
    }
}
