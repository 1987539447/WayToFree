package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-26.
 */

import java.util.Map;
import java.util.concurrent.*;

/**
 * 缓存实现C：增加Future，正在计算中的不再重复计算
 */
public class MemoizerC<A,V> implements Computable<A,V> {

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> c;

    public MemoizerC(Computable<A,V> c) {
        this.c = c;
    }

    /**
     * 缓存中为参数和Future的映射，
     * 通过future.get获取计算结果，直接获得或等待计算结束
     * 缓存中没有时，创建future任务并加入缓存
     * 因复合操作问题，相同参数存在重复计算问题
     * Future的失败和取消会导致缓存污染
     * {@link com.github.siemen.juc.Memoizer}
     * */
    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if(future == null){
            Callable<V> eval = () -> c.compute(arg);
            FutureTask<V> futureTask = new FutureTask<V>(eval);
            future = futureTask;
            cache.put(arg,future);
            futureTask.run();
        }
        try {
            return future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new InterruptedException(e.getMessage());
        }
    }

}
