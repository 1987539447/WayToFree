package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-26.
 */

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 缓存最终实现
 */
public class Memoizer<A,V> implements Computable<A,V> {

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> c;

    public Memoizer(Computable<A,V> c) {
        this.c = c;
    }

    /**
     * 通过putIfAbsent并发处理加入任务操作，
     * 如果加入成功则获得任务，执行计算
     * 加入不成功则获得已有任务
     * 处理异常时清除对应缓存
     * */
    @Override
    public V compute(A arg) throws InterruptedException {
        while (true){
            Future<V> future = cache.get(arg);
            if(future == null){
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> futureTask = new FutureTask<V>(eval);
                future = cache.putIfAbsent(arg,futureTask);//不存在即加入，返回原值，实现同步
                if(future == null){//缓存中不存在加入
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            }catch (CancellationException e){
                //取消异常，删除缓存
                cache.remove(arg);
            }catch (ExecutionException e) {
                e.printStackTrace();
                throw new InterruptedException(e.getMessage());
            }
        }
    }
}
