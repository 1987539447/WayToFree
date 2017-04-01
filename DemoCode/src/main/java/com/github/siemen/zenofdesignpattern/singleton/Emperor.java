package com.github.siemen.zenofdesignpattern.singleton;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 单例模式 - 皇帝
 */
public class Emperor {
    private static Emperor emperor = new Emperor();
    private Emperor(){}
    public static Emperor getInstance(){
        return emperor;
    }
    public void say(){
        System.out.println("我是皇帝嬴政....");
    }
}
