package com.github.siemen.zenofdesignpattern.strategy;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 开绿灯策略
 */
public class GreenLight implements IStrategy{
    @Override
    public void operate() {
        System.out.println(".....找吴国太开绿灯....");
    }
}
