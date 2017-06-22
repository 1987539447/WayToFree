package com.github.siemen.render;
/**
 * Created by Zhan on 2017-06-22.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 单线程顺序渲染页面
 */
public class SingleThreadRender extends Render {

    public SingleThreadRender() {
        super(null);
    }

    void renderPage(CharSequence source){
        renderText(source);
        List<ImageData>  imageData = new ArrayList<>();
        for (ImageInfo imageInfo : scanForImageInfo(source)) {
            imageData.add(imageInfo.downloadImage());
        }
        for (ImageData data : imageData) {
            renderImage(data);
        }
    }


}
