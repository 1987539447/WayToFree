package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-15.
 */


import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 测试AtomicInteger
 */
public class AtomicIntegerTest {
    @Test
    public  void testAll() throws InterruptedException {
        final AtomicInteger value = new AtomicInteger(10);
        assertEquals(value.compareAndSet(1,2),false);//如果原值=1，则设置为2
        assertEquals(value.get(),10);//获取value值
        assertTrue(value.compareAndSet(10,3)); //如果值为10，则设置为3
        assertEquals(value.get(),3); //设置值为3

        value.set(0);
        assertEquals(value.incrementAndGet(),1); //计算 ++value
        assertEquals(value.getAndAdd(2),1); //返回value,然后value+delta 1
        assertEquals(value.getAndAdd(5),3);
        assertEquals(value.get(),8);

        //创建10个线程
        final int threadSize = 10;
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threads[i] = new Thread(){
                @Override
                public void run() {
                    value.incrementAndGet();//执行++value
                }
            };

        }

        for (Thread thread : threads) {//启动线程
            thread.start();
        }

        for (Thread thread : threads) {//等待全部执行结束
            thread.join();
        }

        assertEquals(value.get(),8+threadSize);
    }
}
