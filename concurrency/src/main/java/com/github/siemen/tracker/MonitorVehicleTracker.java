package com.github.siemen.tracker;
/**
 * Created by Zhan on 2017-06-20.
 */

import com.github.siemen.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于监视器的机动车位置追踪
 * 位置设置和获取方法使用synchronized同步
 * 通过可变的MutablePoint存储位置信息
 * 在构建和返回数据时通过拷贝防止信息被修改
 */
@ThreadSafe
public class MonitorVehicleTracker {
    private final Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(this.locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint location = locations.get(id);
        return location == null ? null : new MutablePoint(location);
    }

    public synchronized void setLocation(String id,int x,int y){
        MutablePoint location = this.locations.get(id);
        if(location == null){
            throw new IllegalArgumentException("No Such Vehicle:"+id);
        }
        location.x = x;
        location.y = y;
    }

    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String,MutablePoint> result = new HashMap<>();
        for (String key : result.keySet()) {
            result.put(key,locations.get(key));
        }
        return Collections.unmodifiableMap(result);//返回不可修改map
    }
}
