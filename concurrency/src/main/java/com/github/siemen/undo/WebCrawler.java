package com.github.siemen.undo;
/**
 * Created by Zhan on 2017-06-28.
 */

import com.github.siemen.annotation.GuardedBy;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 网页url搜索
 * 通过TrackinigExecutor保存未完成的任务
 */
public abstract class WebCrawler {
    private static final TimeUnit UNIT = TimeUnit.SECONDS;
    private static final long TIMEOUT = 1000;
    private volatile TrackingExecutor executor;
    @GuardedBy("this")
    private final Set<URL> urlsToCrawler = new HashSet<>();

    public synchronized void start(){
        executor = new TrackingExecutor(Executors.newCachedThreadPool());
        urlsToCrawler.forEach(this::submitCrawlTask);
        urlsToCrawler.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try{
            saveUncrawled(executor.shutdownNow());
            if(executor.awaitTermination(TIMEOUT,UNIT)){
                saveUncrawled(executor.getCancelledTasks());
            }
        }finally {
            executor = null;
        }
    }

    protected abstract List<URL> processPage(URL url);

    private void saveUncrawled(List<Runnable> uncrawled) {
        for (Runnable runnable : uncrawled) {
            urlsToCrawler.add(((CrawlTask)runnable).getPage());
        }
    }

    private class CrawlTask implements Runnable {

        private final URL url;

        private CrawlTask(URL url) {
            this.url = url;
        }

        @Override
        public void run() {
            for (URL link : processPage(url)) {
                if(Thread.currentThread().isInterrupted()){
                    return;
                }
                submitCrawlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }

    private void submitCrawlTask(URL url) {

    }
}
