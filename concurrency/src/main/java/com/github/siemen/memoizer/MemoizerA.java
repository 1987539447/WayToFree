package com.github.siemen.memoizer;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存实现方案A：通过synchronized实现同步，通过HashMap缓存数据
 * synchronized效率低，程序只能顺序运行
 */
public class MemoizerA<A,V> implements Computable<A,V> {


    private final Map<A,V> cache = new HashMap<>();
    private final Computable<A,V> computable;

    public MemoizerA(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = computable.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
