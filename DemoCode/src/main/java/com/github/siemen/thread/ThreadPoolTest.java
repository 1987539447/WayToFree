package com.github.siemen.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by Zhan on 2017/3/21 0021.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a directory:");
        String directory = scanner.nextLine();
        System.out.println("Please enter a keyword to search:");
        String keyword = scanner.nextLine();
        ExecutorService pool = Executors.newCachedThreadPool();
        MathCounter counter = new MathCounter(new File(directory),keyword,pool);
        Future<Integer> result = pool.submit(counter);
        System.out.println(result.get()+" matched files ");

        pool.shutdown();
        int maxSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
        System.out.println("largest pool size: " + maxSize);
    }

    static class MathCounter implements Callable<Integer>{

        private  File directory;
        private  String keyword;
        private  ExecutorService pool;
        private int count;

        public MathCounter(File dir, String keyword, ExecutorService pool){

            this.directory = dir;
            this.keyword = keyword;
            this.pool = pool;
        }

        @Override
        public Integer call() throws Exception {
            count = 0;
            File[] files = this.directory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<>();
            for (File file : files) {
                if(file.isDirectory()){
                    MathCounter counter = new MathCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file)){
                        count++;
                    }
                }
            }
            for (Future<Integer> result : results) {
                count += result.get();
            }
            return count;
        }

        private boolean search(File file) throws FileNotFoundException {
            Scanner scanner = new Scanner(new FileInputStream(file));
            boolean found = false;
            while(!found && scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.contains(keyword)){
                    found = true;
                }
            }
            scanner.close();
            return found;
        }
    }
}
