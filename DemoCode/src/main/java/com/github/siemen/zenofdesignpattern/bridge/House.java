package com.github.siemen.zenofdesignpattern.bridge;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 房子实现类
 */
public class House extends Product {

    @Override
    public void beProducted() {
        System.out.println("盖房子~~~");
    }

    @Override
    public void beSelled() {
        System.out.println("卖房子~~");
    }
}
