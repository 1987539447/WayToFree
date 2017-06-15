package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-26.
 */

import java.math.BigInteger;

/**
 * [缓存示例]
 * 模拟高耗时计算
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //long compute
        return new BigInteger(arg);
    }
}
