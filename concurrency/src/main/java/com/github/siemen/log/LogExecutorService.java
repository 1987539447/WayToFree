package com.github.siemen.log;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 通过ExecutorService实现可关闭的日志服务
 */
public class LogExecutorService {
    private static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final long TIMEOUT = 2000;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Writer writer;

    public LogExecutorService(Writer writer) {
        this.writer = writer;
    }

    public void start(){
        //不需要单独启动
        //注册JVM关闭hook
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try{
                    LogExecutorService.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void stop() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(TIMEOUT,UNIT);
    }

    public void log(String msg){
        try{
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        writer.write(msg);
                    } catch (IOException e) {
                        //
                    }
                }
            });
        }catch (RejectedExecutionException ex){

        }
    }
}
