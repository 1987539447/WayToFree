package com.github.siemen.memoizer;
/**
 * Created by Zhan on 2017-06-22.
 */

import com.github.siemen.exception.ExceptionHandler;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 缓存最终实现方案
 * 通过putIfAbsent保证加入缓存的计算Future对同一个值仅能有一个
 * 并处理计算异常的future
 */
public class Memoizer<A,V> implements Computable<A,V>{

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> computable;

    public Memoizer(Computable<A, V> computable) {
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
            future = cache.putIfAbsent(arg,task);//同步的检查并设置
            if(future == null){//不存在，且加入成功
                future = task;
                task.run();
            }
        }
        try {
            return future.get();
        } catch (CancellationException e){
            cache.remove(arg,future);//移除被取消计算
        }catch (ExecutionException e) {
            throw ExceptionHandler.launderThrowable(e.getCause());
        }
        return null;
    }
}
