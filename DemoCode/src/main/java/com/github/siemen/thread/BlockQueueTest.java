package com.github.siemen.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Zhan on 2017/3/21 0021.
 */
public class BlockQueueTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory:");
        String directory = scanner.nextLine();
        System.out.println("Please entery a keyword to search:");
        String keyword = scanner.nextLine();
        final  int QUEUE_SIZE = 10;
        final  int TASK_SIZE = 100;
        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(QUEUE_SIZE);
        FileEmurationTask task = new FileEmurationTask(queue,new File(directory));
        new Thread(task).start();
        for (int i = 0; i < TASK_SIZE; i++) {
            new Thread(new SearchTask(queue,keyword)).start();
        }
    }

    static class SearchTask implements Runnable {
        private  BlockingQueue<File> queue;
        private  String keyword;

        public SearchTask(BlockingQueue<File> queue, String keyword) {
            this.queue = queue;
            this.keyword = keyword;
        }

        @Override
        public void run() {
            boolean done = false;
            try{
                while (!done){
                    File file = queue.take();
                    if(file == FileEmurationTask.DUMY){
                        done = true;
                        queue.put(file);
                    }else{
                        search(file);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void search(File file) throws FileNotFoundException {
            Scanner scanner = new Scanner(new FileInputStream(file));
            String line = "";
            int lineNo = 0;
            while (scanner.hasNext()){
                lineNo++;
                line = scanner.nextLine();
                if(line.contains(keyword)){
                    System.out.printf("%s:%d %s%n",file.getPath(),lineNo,line);
                }
            }
            scanner.close();
        }
    }

    static class FileEmurationTask implements Runnable{

        private static final File DUMY = new File("");
        private  BlockingQueue queue;
        private  File startingDir;

        public FileEmurationTask(BlockingQueue queue, File dir){
            this.queue = queue;
            this.startingDir = dir;
        }
        @Override
        public void run() {
            try {
                    emurate(this.startingDir);
                    queue.put(DUMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

        private void emurate(File dir) throws InterruptedException {
            File[] files = dir.listFiles();
            for (File file : files) {
                if(file.isDirectory()){
                    emurate(file);
                }else{
                    queue.put(file);
                }
            }
        }
    }
}
