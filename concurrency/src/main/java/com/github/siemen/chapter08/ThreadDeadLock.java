package com.github.siemen.chapter08;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单线程Executor中死锁
 * 渲染页面任务将渲染页眉-页脚任务提交到相同executor
 * 相互等待对方任务完成
 */
public class ThreadDeadLock {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Future<String> header,footer;
            header = executor.submit(new LoadFileTask("head.html"));
            footer = executor.submit(new LoadFileTask("foot.html"));
            String page = renderBody();
            return header+ page + footer;
        }
    }

    private String renderBody() {
        return null;
    }

    private class LoadFileTask implements Callable<String> {
        public LoadFileTask(String s) {
        }

        @Override
        public String call() {
            return null;
        }
    }
}
