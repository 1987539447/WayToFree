package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-15.
 */

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 测试AtomicIntegerFieldUpdater
 * 通过反射实现
 * 字段必须是volatile
 * 字段访问权限必须与调用者操作字段关系一致
 */
public class AtomicIntegerFileUpdateDemo {

    class DemoData{
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String field){
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class,field);
    }

    void doit(){
        DemoData data = new DemoData();
        System.out.println("1==>"+getUpdater("value1").getAndSet(data,10));
        System.out.println("3==>"+getUpdater("value2").incrementAndGet(data));
        //System.out.println("2==>"+getUpdater("value3").decrementAndGet(data));//不能访问
        //System.out.println("true==>"+getUpdater("value4").compareAndSet(data,4,5));//不能访问
    }

    public static void main(String[] args) {
        AtomicIntegerFileUpdateDemo demo = new AtomicIntegerFileUpdateDemo();
        demo.doit();
    }
}
