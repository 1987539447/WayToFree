package com.github.siemen.zenofdesignpattern.strategy;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 赵云-策略使用
 */
public class ZhaoYun {
    public static void main(String[] args) {
        Context context;
        System.out.println("-------刚到吴国拆开第一个---------");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("--------刘备乐不思蜀拆开第二个--------");
        context = new Context(new GreenLight());
        context.operate();
        System.out.println("---------孙权追兵来拆开第三个---------");
        context = new Context(new BlockEnemy());
        context.operate();
        System.out.println("---------------end--------------");
    }
}
