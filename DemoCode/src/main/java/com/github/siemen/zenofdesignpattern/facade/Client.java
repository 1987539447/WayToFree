package com.github.siemen.zenofdesignpattern.facade;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 客户端-调用门面
 */
public class Client {
    public static void main(String[] args) {
        ModenPostOffice postOffice = new ModenPostOffice();
        postOffice.sendLetter("hello,world","Program Road,Java 01");
    }
}
