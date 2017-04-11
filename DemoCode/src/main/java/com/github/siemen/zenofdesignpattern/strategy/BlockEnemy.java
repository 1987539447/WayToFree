package com.github.siemen.zenofdesignpattern.strategy;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 阻挡敌人策略
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("....孙夫人断后阻止追兵....");
    }
}
