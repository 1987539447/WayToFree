package com.github.siemen.log;
/**
 * Created by Zhan on 2017-06-23.
 */

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者 分离写日志操作
 * 不支持关闭，队列中未处理任务被丢弃
 */
public class LogWriter {
    private static final int CAPACITY = 100;
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;

    private boolean shutdownRequest;

    public LogWriter(Writer writer) {
        this.queue = new LinkedBlockingQueue<>(CAPACITY);
        this.logger = new LoggerThread(writer);
    }

    public void start (){
        logger.start();
    }

    public void log(String msg) throws InterruptedException {
        queue.put(msg);
        //不可靠的关闭，检查在运行存在竞争条件，另put阻塞操作会无法检测到关闭状态
/*        if(!shutdownRequest) {
            queue.put(msg);
        }else{
            throw new IllegalStateException("Logger is shut down");
        }*/
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        private LoggerThread(Writer writer) {
            this.writer = (PrintWriter) writer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    writer.write(queue.take());
                } catch (InterruptedException e) {
                    writer.close();
                }
            }
        }
    }
}
