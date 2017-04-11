package com.github.siemen.zenofdesignpattern.bridge;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 山寨ipod
 */
public class IPod extends Product {

    @Override
    public void beProducted() {
        System.out.println("生成山寨ipod……");
    }

    @Override
    public void beSelled() {
        System.out.println("卖掉山寨ipod……");
    }
}
