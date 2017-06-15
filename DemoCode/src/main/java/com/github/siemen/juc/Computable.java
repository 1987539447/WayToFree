package com.github.siemen.juc;

/**
 *
 * Created by Zhan on 2017-05-26.
 * [缓存示例]
 * 计算接口，执行特定计算
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
