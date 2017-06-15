package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.util.List;
import java.util.concurrent.*;

/**
 * 通过CompletionService执行图片下载
 * 每个图片下载封装为单独的Callable任务
 * 提交给completionService执行，submit
 * 渲染文本
 * 通过take从完成服务的队列中获取已完成的任务future
 * 通过future.get获取图片信息并渲染
 */
public class Render {
    private static final String DEFAULT_AD = "NO AD";
    private final ExecutorService executor;

    private static final int TIME_BUDGET = 100000;

    public Render(ExecutorService executor) {
        this.executor = executor;
    }

    public void renderPage(CharSequence soure){

        final List<String> imageInfo = scanForImageInfo(soure);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
        for (final String image : imageInfo) {
            completionService.submit(() -> download(image));
        }
        renderText(soure);
        for (int i = 0; i < imageInfo.size(); i++) {
            try {
                Future<String> future = completionService.take();
                String img = future.get();
                renderImage(img);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void renderPageWithAd(){
        long endNanos = System.nanoTime() + TIME_BUDGET;
        Future<String> future = this.executor.submit(() -> "--------google ads-------");
        long timeLeft = endNanos - System.nanoTime();
        String ad;
        try {
            ad = future.get(timeLeft,TimeUnit.NANOSECONDS); //给future.get指定等待时间
        } catch (InterruptedException e) {//被打断
            e.printStackTrace();
            ad = DEFAULT_AD;
        } catch (ExecutionException e) {//任务执行异常
            e.printStackTrace();
            ad = DEFAULT_AD;
        } catch (TimeoutException e) {//超时
            e.printStackTrace();
            ad = DEFAULT_AD;
        }
        System.out.println(ad);
    }


    private  void renderImage(String s) {
        System.out.println(s);
    }

    private  void renderText(CharSequence source) {
        String[] src = String.valueOf(source).split(",");
        for (String s : src) {
            if(s.startsWith("[txt]")){
                System.out.println(s);
            }
        }
    }

    private  String download(String image) {
        return null;
    }

    private  List<String> scanForImageInfo(CharSequence source) {
        return null;
    }

    private  String makeSource() {
        return null;
    }

    public static void main(String[] args) {
        Render render = new Render(Executors.newFixedThreadPool(10));
        render.renderPage(render.makeSource());
    }
}
