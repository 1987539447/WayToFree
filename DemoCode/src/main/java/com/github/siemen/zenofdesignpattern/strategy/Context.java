package com.github.siemen.zenofdesignpattern.strategy;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 策略封装类
 */
public class Context {

    private IStrategy strategy;
    public Context(IStrategy strategy){
        this.strategy = strategy;
    }
    public void operate(){
        this.strategy.operate();
    }
}
