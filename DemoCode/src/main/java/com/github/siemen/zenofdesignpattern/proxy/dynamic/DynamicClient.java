package com.github.siemen.zenofdesignpattern.proxy.dynamic;
/**
 * Created by Zhan on 2017-03-31.
 */

/**
 * 动态代理调用
 */
public class DynamicClient {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = SubjectDynamicPorxy.newProxyInstance(subject);
        proxy.doWork();
    }
}
