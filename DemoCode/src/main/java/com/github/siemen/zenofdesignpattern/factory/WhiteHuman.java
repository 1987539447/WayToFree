package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 白色人种
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色皮肤");
    }

    @Override
    public void talk() {
        System.out.println("白种人语言~");
    }
}
