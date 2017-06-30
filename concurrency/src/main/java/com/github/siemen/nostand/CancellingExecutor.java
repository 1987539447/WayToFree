package com.github.siemen.nostand;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.util.concurrent.*;

/**
 * 可取消的Executor
 */
public class CancellingExecutor extends ThreadPoolExecutor {

    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if(callable instanceof CancellableTask ){
            return ((CancellableTask)callable).newTask();
        }
        return super.newTaskFor(callable);
    }
}
