package com.github.siemen.crawler;
/**
 * Created by Zhan on 2017-06-28.
 */

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * 文件索引服务
 * 使用致命药丸来控制服务停止
 * 停止生产者时设置标志
 * 消费者检查标志
 */
public class IndexingService {

    private static final File POISON = new File("");
    private final CrawlerThread producer = new CrawlerThread();
    private final IndexThread consumer = new IndexThread();
    private final BlockingQueue<File> queue;
    private final FileFilter filter;
    private final File root;

    public IndexingService(BlockingQueue<File> queue, FileFilter filter, File root) {
        this.queue = queue;
        this.filter = filter;
        this.root = root;
    }

    public void start(){
        producer.start();
        consumer.start();
    }

    public void stop(){
        //只中断生产者，消费者判断POISON后自动停止
        producer.interrupt();
    }

    public void awaitTermination() throws InterruptedException {
        consumer.join();
    }


    class CrawlerThread extends Thread{
        @Override
        public void run() {
            try{
                crawl(root);
            }catch (InterruptedException e){

            }finally {
                while (true) {//放置致命药丸
                    try {
                        queue.put(POISON);
                    } catch (InterruptedException e) {
                        //retry
                    }
                }
            }
        }

        private void crawl(File root) throws InterruptedException{

        }
    }
    class IndexThread extends Thread{

        @Override
        public void run() {
            try{
                while (true) {
                    File file = queue.take();
                    if(file == POISON){
                        break;//取到结束标志则停止
                    }else{
                        index(file);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void index(File file) {

        }
    }
}
