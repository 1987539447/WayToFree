package com.github.siemen.memoizer;
/**
 * Created by Zhan on 2017-06-22.
 */

/**
 * 计算接口
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
