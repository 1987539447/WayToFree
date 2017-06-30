package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *自定制线程
 * 根据线程名和创建次序设置名称
 * 设置UEHandler 处理未捕获异常
 * 记录日志
 */
public class MyAppThread extends Thread {

    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debug = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger logger = Logger.getAnonymousLogger();

    public MyAppThread(Runnable r){
        this(r,DEFAULT_NAME);
    }

    public MyAppThread(Runnable r, String poolName) {
        super(r,poolName+"-"+created.incrementAndGet());
        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logger.log(Level.SEVERE,"UncaughtException in "+t.getName(),e);
            }
        });
    }

    @Override
    public void run() {
        if(debug){
            logger.log(Level.FINE,"Created : "+getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            if(debug){
                logger.log(Level.FINE,"Exitinig : "+getName());
            }
        }

    }


    public static int getAliveThread(){
        return alive.get();
    }
    public static int getCreatedThread(){
        return created.get();
    }
    public static boolean getDebug(){
        return debug;
    }
    public static void setDebug(boolean b){
        debug = b;
    }
}
