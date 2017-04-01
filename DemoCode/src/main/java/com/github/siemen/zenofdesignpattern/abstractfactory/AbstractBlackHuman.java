package com.github.siemen.zenofdesignpattern.abstractfactory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 黑色人种抽象
 */
public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色皮肤~");
    }

    @Override
    public void talk() {
        System.out.println("黑种人~");
    }
}
