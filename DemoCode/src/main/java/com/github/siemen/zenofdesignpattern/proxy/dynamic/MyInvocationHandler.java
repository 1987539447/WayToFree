package com.github.siemen.zenofdesignpattern.proxy.dynamic;
/**
 * Created by Zhan on 2017-03-31.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理Hadler
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object obj){
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
