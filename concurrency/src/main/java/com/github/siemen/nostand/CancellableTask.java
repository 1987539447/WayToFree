package com.github.siemen.nostand;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * Created by Zhan on 2017-06-23.
 * 可取消任务接口，增加取消方法
 */
public interface CancellableTask<T> extends Callable<T> {

    void cancel();
    RunnableFuture<T> newTask();
}
