package com.github.siemen.zenofdesignpattern.abstractfactory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 女性黑色人种
 */
public class FemaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑人女性~");
    }
}
