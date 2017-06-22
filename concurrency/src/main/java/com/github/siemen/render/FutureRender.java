package com.github.siemen.render;
/**
 * Created by Zhan on 2017-06-22.
 */

import com.github.siemen.exception.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Future渲染图片，get阻塞等待图片加载完成
 * 分开文本和图片，但需要等待所有图片下载完
 */
public class FutureRender extends Render {

    private final ExecutorService exec = Executors.newSingleThreadExecutor();

    public FutureRender() {
        super(null);
    }

    void renderPage(CharSequence source){
        final List<ImageInfo> imageInfoList = scanForImageInfo(source);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> list = new ArrayList<>();
                for (ImageInfo imageInfo : imageInfoList) {
                    list.add(imageInfo.downloadImage());
                }
                return list;
            }
        };
        Future<List<ImageData>> future = exec.submit(task);
        renderText(source);

        try{
            List<ImageData> imageDataList = future.get();//阻塞等待
            for (ImageData imageData : imageDataList) {
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//重设中断位
        } catch (ExecutionException e) {
            throw ExceptionHandler.launderThrowable(e.getCause());
        }

    }

}
