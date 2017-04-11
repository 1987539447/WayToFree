package com.github.siemen.zenofdesignpattern.observer;
/**
 * Created by Zhan on 2017-04-06.
 */

import java.util.Observable;

/**
 * 观察者测试
 */
public class Client {

    public static void main(String[] args) {
        HanFeiZi han = new HanFeiZi();
        LiSi li = new LiSi();
        han.addObserver(li);
        han.haveBreakfast();
        han.haveFun();
    }
}
