package com.github.siemen.log;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 日志服务
 * 实现可靠的取消
 * 同步竞争条件isShutdown
 * 通过interrupt中断消费者
 * 通过计数判定是否还有未写完的日志
 */
public class LogService {

    private static final int CAPACITY = 100;
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;
    private boolean isShutdwon;
    private int reservations;

    public LogService(PrintWriter writer) {
        this.writer = writer;
        this.queue = new LinkedBlockingQueue<>(CAPACITY);
        this.loggerThread = new LoggerThread();
    }

    public void start(){
        loggerThread.start();
    }

    public void stop(){
        //设置标志位，停止生产者
        //中断写日志操作，停止消费者
        synchronized (this){
            this.isShutdwon = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if(isShutdwon){
                throw new IllegalStateException("...Log servcie is shutdown...");
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends  Thread{

        @Override
        public void run() {
            try {
                while (true){
                    synchronized (LogService.this){
                        if(isShutdwon && reservations ==0){
                            break;
                        }
                    }
                    String msg = queue.take();
                    synchronized (LogService.this){
                        --reservations;
                    }
                    writer.write(msg);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                writer.close();
            }
        }
    }
}
