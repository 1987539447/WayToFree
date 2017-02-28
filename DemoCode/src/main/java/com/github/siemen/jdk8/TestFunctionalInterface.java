package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 * 函数接口
 * 静态引用 ::
 */
public class TestFunctionalInterface {


    public static void main(String[] args) {
        //Convert<String,Integer> convert = (x) -> Integer.valueOf(x);
        Convert<String,Integer> convert = Integer::valueOf;
        Integer converted = convert.convert("123");
        System.out.println(converted);
    }
}
