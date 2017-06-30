package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * 扩展Executor
 * 通过Executor钩子函数扩展，增加时间统计功能
 * 通过ThreadLocal存储线程启动时间
 */
public class TimingThreadPool extends ThreadPoolExecutor{

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final AtomicLong totalTime = new AtomicLong();
    private final AtomicLong numTasks = new AtomicLong();
    private final Logger logger = Logger.getLogger("TimingThreadPool");

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.fine(String.format("Trhead %s start %s",t,r));
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {

            long endTime = System.nanoTime();
            long runTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(runTime);
            logger.fine(String.format("Thread %s end %s time=%dns",t,r,runTime));
        }finally {
            super.afterExecute(r, t);
        }

    }

    @Override
    protected void terminated() {
        try {
            logger.info(String.format("Termiated : avg time = %dns",totalTime.get()/numTasks.get()));
        }finally {
            super.terminated();
        }

    }

    public static void main(String[] args) {
        TimingThreadPool pool = new TimingThreadPool(10,10,0L,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("------do some work------");
                }
            });
        }
        //pool.shutdown();
    }
}
