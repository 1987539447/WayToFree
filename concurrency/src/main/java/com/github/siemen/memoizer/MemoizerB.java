package com.github.siemen.memoizer;
/**
 * Created by Zhan on 2017-06-22.
 */


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存方案B：通过ConcurrentHashMap实现
 * concurrentHashMap保证了put和get操作的原子性
 * 但存在同一个值被同时反复计算的可能
 */
public class MemoizerB<A,V> implements Computable<A,V> {



    private final Map<A,V> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> computable;

    public MemoizerB(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public  V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = computable.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
