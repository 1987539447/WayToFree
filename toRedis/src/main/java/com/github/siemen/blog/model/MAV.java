package com.github.siemen.blog.model;
/**
 * Created by Zhan on 2017-06-12.
 */

/**
 * 数据-视图
 */
public class MAV {
    private String url;
    private Object data;

    public MAV(Object data, String url) {
        this.data = data;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
