package com.github.siemen.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Zhan on 2017/3/22 0022.
 * 基于LinkedHashMap实现LRU缓存
 * 构建一个固定大小LinkdeHashMap，指定按访问序排序
 * 重写移除最老元素方法
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;
    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
        }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}