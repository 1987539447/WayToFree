package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义executor
 * 创建后可通过setter修改设置
 */
public class CustomExecutor {
    private static final int CAPACITY = 200;
    private static final int N_THREADS = 20;

    public static void main(String[] args) {
        //核心线程-最大线程-存活时间-时间单位-阻塞队列
        ThreadPoolExecutor executor = new ThreadPoolExecutor(N_THREADS,N_THREADS,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(CAPACITY));
        //设置拒绝策略：终止-遗弃-遗弃最老-调用者运行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setCorePoolSize(100);
    }
}
