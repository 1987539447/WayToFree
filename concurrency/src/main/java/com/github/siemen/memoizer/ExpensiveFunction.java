package com.github.siemen.memoizer;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.math.BigInteger;

/**
 * 耗时计算，计算接口实现类
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {

        //sleep模拟耗时
        Thread.currentThread().sleep(1000);
        return new BigInteger(arg);
    }
}
