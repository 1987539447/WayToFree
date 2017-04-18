package com.github.siemen.zenofdesignpattern.minitrade;

/**
 * Created by Zhan on 2017-04-18.
 * 策略枚举
 */
public enum StrategyMan {
    SteadyDedution("com.github.siemen.zenofdesignpattern.minitrade.SteadyDeduction"),
    FreeDedution("com.github.siemen.zenofdesignpattern.minitrade.FreeDeduction");

    private final String value;

    StrategyMan(String value) {
        this.value = value;
    }

    public String getValue(){
        return  this.value;
    }
}
