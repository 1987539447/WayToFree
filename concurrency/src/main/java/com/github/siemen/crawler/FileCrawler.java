package com.github.siemen.crawler;
/**
 * Created by Zhan on 2017-06-21.
 */

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者-消费者：文件搜索-生产者
 */
public class FileCrawler implements Runnable{

    private final BlockingQueue<File> fileQueu;
    private final FileFilter fileFilter;
    private final File root;

    public FileCrawler(BlockingQueue<File> fileQueu, FileFilter fileFilter, File root) {
        this.fileQueu = fileQueu;
        this.fileFilter = fileFilter;
        this.root = root;
    }



    @Override
    public void run() {
        try {
            crawler(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawler(File root) throws InterruptedException{
        File[] entries = root.listFiles();
        if(entries != null){
            for (File entry : entries) {
                if(entry.isDirectory()){
                    crawler(entry);
                }else if(!alreadyIndexed(entry)){
                    fileQueu.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File entry) {
        return false;
    }
}
