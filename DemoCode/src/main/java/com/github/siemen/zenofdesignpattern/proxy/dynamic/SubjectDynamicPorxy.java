package com.github.siemen.zenofdesignpattern.proxy.dynamic;
/**
 * Created by Zhan on 2017-03-31.
 */

import java.lang.reflect.InvocationHandler;

/**
 * 对应主题动态代理类
 */
public class SubjectDynamicPorxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject subject){
        ClassLoader loader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler handler = new MyInvocationHandler(subject);
        return newProxyInstance(loader,interfaces,handler);
    }
}
