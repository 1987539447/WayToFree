package com.github.siemen.zenofdesignpattern.singleton;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 单例模式-大臣类
 */
public class Minister {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
