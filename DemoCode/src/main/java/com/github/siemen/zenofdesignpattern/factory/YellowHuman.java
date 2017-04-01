package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 黄色人种
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色皮肤");
    }

    @Override
    public void talk() {
        System.out.println("黄种人语言~");
    }
}
