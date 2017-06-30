package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 限制任务提交的executor
 * 通过信号量限制提交的任务数
 * 提交前获取许可，执行后无论正常结束或异常结束释放许可
 */
public class BoundedExecutor {
    private final ExecutorService executorService;
    private final Semaphore semaphore;

    public BoundedExecutor(ExecutorService executorService,int bound) {
        this.executorService = executorService;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();//提交前获取许可
        try {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }
}
