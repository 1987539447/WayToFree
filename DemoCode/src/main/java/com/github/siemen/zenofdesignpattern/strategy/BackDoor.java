package com.github.siemen.zenofdesignpattern.strategy;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 走后门策略
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println(".......找乔国老开后门......");
    }
}
