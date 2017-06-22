package com.github.siemen.crawler;
/**
 * Created by Zhan on 2017-06-21.
 */

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 文件索引-消费者
 */
public class Indexer implements Runnable {

    private static final int BOUND = 300;
    private static final int N_CONSUMERS = 10;
    private final BlockingQueue<File> fileQueue;

    public Indexer(BlockingQueue<File> fileQueue) {
        this.fileQueue = fileQueue;
    }

    @Override
    public void run() {
        try {
                while (true){
                    indexFile(fileQueue.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

    }

    private void indexFile(File file) {
        System.out.println(file.getName());
    }

    public static void startIndexing(File[] roots){
        BlockingQueue<File> fileQueue = new LinkedBlockingQueue<>(BOUND);
        FileFilter fileFilter = pathname -> true;
        for (File root : roots) {
            new Thread(new FileCrawler(fileQueue,fileFilter,root)).start();
        }
        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new Indexer(fileQueue)).start();
        }
    }

    public static void main(String[] args) {
        File[] roots = {new File("D:\\siemen")};
        Indexer.startIndexing(roots);
    }
}
