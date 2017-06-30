package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.CountDownLatch;

/**
 * 可携带结果的闭锁
 * 一旦设置结果则打开锁
 */
public class ValueLatch<T> {
    private T value = null;
    private CountDownLatch done = new CountDownLatch(1);

    public boolean isSet() {
        return done.getCount() == 0;
    }

    public synchronized void setValue(T t) {
        if (!isSet()) {
            value = t;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this) {
            return value;
        }
    }
}
