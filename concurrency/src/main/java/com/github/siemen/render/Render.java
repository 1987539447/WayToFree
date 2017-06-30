package com.github.siemen.render;
/**
 * Created by Zhan on 2017-06-22.
 */

import com.github.siemen.exception.ExceptionHandler;

import java.util.List;
import java.util.concurrent.*;

/**
 * 通过CompletionServie渲染图片，针对下载完的图片立即渲染
 * 任务完成后备加入FutureQueue
 *
 * 限时加载广告，执行get时指定阻塞最大时长
 */
public class Render {

    private static final long TIME_BUDGET = 1000;
    private final ExecutorService executor;

    public Render(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source){
        final List<ImageInfo> imageInfoList = scanForImageInfo(source);
        CompletionService<ImageData> service = new ExecutorCompletionService<ImageData>(this.executor);
        for (ImageInfo imageInfo : imageInfoList) {
            service.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }
        renderText(source);

            try {
                for (int i = 0; i < imageInfoList.size(); i++) {
                    Future<ImageData> future = service.take();//阻塞，从FutureQueue获得完成的future
                    ImageData data = future.get();
                    renderImage(data);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw ExceptionHandler.launderThrowable(e.getCause());
            }
    }


    protected List<ImageInfo> scanForImageInfo(CharSequence source){
        return null;
    }

    protected void renderText(CharSequence source){
        System.out.println("----------Text render-----");
    }

    protected void renderImage(ImageData data) {
        System.out.println("-------image render-------");
    }

    Page renderPageWitAd() {


        long endNanos = System.nanoTime() + TIME_BUDGET;
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //long wati
                return "---add content---------";
            }
        });
        Page page = renderBody();
        long timeLeft = endNanos - System.nanoTime();
        String ad = "default ad----";
        try {
            ad = future.get(timeLeft, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            ad = "defualt ad";
        } catch (ExecutionException e) {
            e.printStackTrace();
            ad = "default ad";
            future.cancel(true);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        page.setAd(ad);
        return page;

    }

    private Page renderBody() {
        return null;
    }

    private class Page {
        private String ad;

        public void setAd(String ad) {
            this.ad = ad;
        }
    }
}
