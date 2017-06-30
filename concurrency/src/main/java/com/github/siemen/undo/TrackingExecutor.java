package com.github.siemen.undo;
/**
 * Created by Zhan on 2017-06-28.
 */

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 获得取消时正在执行的任务
 * 重写execute方法，在interrupted时加入集合
 */
public class TrackingExecutor extends AbstractExecutorService {

    private final ExecutorService executor;
    private Set<Runnable> taskCancelledAtShutdown = Collections.synchronizedSet(new HashSet<>());

    public TrackingExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public List<Runnable> getCancelledTasks(){
        if(!executor.isTerminated()){
            throw new IllegalStateException("---still running---");
        }else {
            return new ArrayList<>(this.taskCancelledAtShutdown);
        }
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    command.run();
                }finally {
                    if(isShutdown() && Thread.currentThread().isInterrupted()){
                        taskCancelledAtShutdown.add(command);
                    }
                }
            }
        });
    }


    @Override
    public void shutdown() {
        this.executor.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }


}
