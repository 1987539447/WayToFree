package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-26.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存实现B：通过ConcurrentHashMap
 */
public class MemoizerB<A,V> implements Computable<A,V> {

    private final Map<A,V> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> c;

    public MemoizerB(Computable<A,V> c) {
        this.c = c;
    }

    /**
     * ConcurrentHashMap自身实现同步，不需要额外同步
     * 先判断再计算的复合操作导致出现重复计算
     * 不能直接获取正在计算中的结果
     * {@link com.github.siemen.juc.MemoizerC}
     * */
    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
