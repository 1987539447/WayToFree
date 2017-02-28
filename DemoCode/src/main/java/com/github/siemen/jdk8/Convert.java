package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 * 函数式接口 @FunctionalInterface 注解
 * 没有注解也可以
 */
@FunctionalInterface
public interface Convert <F,T>{
    T convert(F from);
}
