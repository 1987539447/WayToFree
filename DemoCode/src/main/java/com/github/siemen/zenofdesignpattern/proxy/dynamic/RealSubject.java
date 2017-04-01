package com.github.siemen.zenofdesignpattern.proxy.dynamic;
/**
 * Created by Zhan on 2017-03-31.
 */

/**
 * 主题实现类
 */
public class RealSubject implements Subject {
    @Override
    public void doWork() {
        System.out.println("劳动光荣~");
    }
}
