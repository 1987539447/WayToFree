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
 */
public class Render {

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
}
