package com.github.siemen.memoizer;
/**
 * Created by Zhan on 2017-06-22.
 */

import com.github.siemen.exception.ExceptionHandler;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 缓存方案C：不缓存结果而是缓存计算Future,因此可以等待同一个值正在计算中结果
 * 仍然存在没有注册计算导致同一个值反复计算，另Future计算异常导致缓存污染
 */
public class MemoizerC<A,V> implements Computable<A,V>{

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> computable;

    public MemoizerC(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public  V compute(final A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if(future == null){
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return computable.compute(arg);
                }
            };
            FutureTask task = new FutureTask(eval);
            future = task;
            cache.put(arg,task);//先加入缓存再计算
            task.run();

        }
        try {
            return future.get();
        } catch (ExecutionException e) {
            throw ExceptionHandler.launderThrowable(e.getCause());
        }
    }
}
