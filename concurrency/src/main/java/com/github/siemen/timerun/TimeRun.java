package com.github.siemen.timerun;
/**
 * Created by Zhan on 2017-06-23.
 */

import com.github.siemen.exception.ExceptionHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 限时运行一个任务
 * 定时去运行一个中断任务
 *
 * 通过futrue取消任务
 */
public class TimeRun {

    private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

    public static void timeRun(Runnable r, long time, TimeUnit unit) throws InterruptedException {
        //可重新抛出异常的任务
        class RethrowableTask implements Runnable{

            private volatile Throwable t;

            @Override
            public void run() {
                try{
                    r.run();
                }catch (Throwable t){
                    this.t = t;
                }
            }

            void rethrow(){
                if(this.t != null){
                    throw ExceptionHandler.launderThrowable(t);
                }
            }
        }
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        //启动任务并定时一个中断操作
        //通过join等待指定时间后，如有异常重新抛出
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        },time,unit);
        taskThread.join(unit.toMillis(time));
        task.rethrow();

    }
}
