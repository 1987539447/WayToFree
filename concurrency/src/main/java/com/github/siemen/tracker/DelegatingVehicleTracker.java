package com.github.siemen.tracker;
/**
 * Created by Zhan on 2017-06-20.
 */

import com.github.siemen.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于委托-将线程安全委托给ConcurrenctHashMap
 * 位置获取和修改委托给底层ConcurrentHashMap实现
 * 同时提供一个不可修改Map视图返回所有位置信息
 */
@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map getLocations(){
        //可获得最新修改信息
        return this.unmodifiableMap;
        //返回位置信息的快照，仅针对调用时刻
        //return Collections.unmodifiableMap(new HashMap<>(this.locations));
    }

    public Point getLocation(String id) {
        return this.locations.get(id);
    }

    public void setLocations(String id,int x,int y){
        if(this.locations.replace(id,new Point(x,y)) == null){
            throw new IllegalArgumentException("invalid vehicle name:"+id);
        }
    }
}
