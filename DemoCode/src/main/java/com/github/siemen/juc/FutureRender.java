package com.github.siemen.juc;
/**
 * Created by Zhan on 2017-05-27.
 */

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 通过future获取图片加载结果
 * 把所有的图片下载打包为一个Callable任务，提交executor执行 submit,返回future
 * 先渲染文本
 * 通过future.get获取图片下载数据
 * 渲染图片
 * 问题：所有图片在一个任务下载，耗时长
 */
public class FutureRender {

    private static final int MAX_THREAD = 10;
    private static final ExecutorService exec = Executors.newFixedThreadPool(MAX_THREAD);

    public static void main(String[] args) {
        CharSequence source = makeSource();
        renderPage(source);
    }

    private static void renderPage(CharSequence source) {
        final List<String> imageInfo = scanForImageInfo(source);
        Callable<List<String>> task = () -> {
            List<String> result = imageInfo.stream().map(FutureRender::download).collect(Collectors.toList());
            return result;
        };

        Future<List<String>> future = exec.submit(task);
        renderText(source);

        try {
            List<String> imageData = future.get();
            imageData.forEach(FutureRender::renderImage);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void renderImage(String s) {
        System.out.println(s);
    }

    private static void renderText(CharSequence source) {
        String[] src = String.valueOf(source).split(",");
        for (String s : src) {
            if(s.startsWith("[txt]")){
                System.out.println(s);
            }
        }
    }

    private static String download(String image) {
        return null;
    }

    private static List<String> scanForImageInfo(CharSequence source) {
        return null;
    }

    private static String makeSource() {
        return null;
    }
}
