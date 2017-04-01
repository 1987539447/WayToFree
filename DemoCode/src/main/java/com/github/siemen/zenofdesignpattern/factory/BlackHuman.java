package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 黑种人
 */
public class BlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黑色皮肤");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种语言~");
    }
}
