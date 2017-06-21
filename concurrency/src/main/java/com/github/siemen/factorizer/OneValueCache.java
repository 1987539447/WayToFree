package com.github.siemen.factorizer;
/**
 * Created by Zhan on 2017-06-19.
 */

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 缓存数字和因数的不可变容器
 * 使用private final类型对象
 * 针对数组对象，通过拷贝构建，避免引用逸出被修改
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger num, BigInteger[] factors) {
        this.lastNumber = num;
        this.lastFactors = Arrays.copyOf(factors,factors.length);
    }

    public BigInteger[] getFactors(BigInteger num){
        if(lastNumber == null || !lastNumber.equals(num)){
            return null;
        }
        return Arrays.copyOf(lastFactors,lastFactors.length);
    }
}
