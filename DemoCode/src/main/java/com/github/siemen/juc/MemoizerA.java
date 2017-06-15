package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-26.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 线程安全
 * 缓存实现A：通过HashMap+同步方法
 */
public class MemoizerA<A,V> implements Computable<A,V> {

    private final Map<A,V> cache = new HashMap<>();
    private final Computable<A,V> c;

    public MemoizerA(Computable<A,V> c) {
        this.c = c;
    }

    /**
     * 先从缓存取，如果没有则计算
     * synchronized只能线性执行，如耗时长将阻塞
     * {@link com.github.siemen.juc.MemoizerB}
     * */
    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
