package com.github.siemen.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhan on 2017/2/28 0028.
 * Lambda表达式 () -> {}
 */
public class TestLambda {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Jack","Rose","zhangsan");
        Collections.sort(nameList,(String a, String b) -> b.compareTo(a));
        for (String s : nameList) {
            System.out.println(s);
        }

        Runnable oldRunable = new Runnable() {
            @Override
            public void run() {
                System.out.println("--------"+Thread.currentThread().getName()+"---oldRuannable");
            }
        };
        Runnable newRunnable = () -> System.out.println("--------"+Thread.currentThread().getName()+"---newRuannable");

        new Thread(oldRunable).start();
        new Thread(newRunnable).start();
    }
}
