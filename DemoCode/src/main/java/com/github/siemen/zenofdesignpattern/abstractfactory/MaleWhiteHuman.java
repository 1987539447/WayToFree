package com.github.siemen.zenofdesignpattern.abstractfactory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 白人男性
 */
public class MaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("白人男性~");
    }
}
