package com.github.siemen.tracker;
/**
 * Created by Zhan on 2017-06-21.
 */

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 发布了底层的安全状态的机动车追踪
 * 线程安全委托给底层ConcurentHashMap
 * 返回的不可修改视图不能被修改，但其中元素，机动车位置可被修改
 * 底层的SafePoint被发布，并且可安全修改
 */
public class PublishingVehicleTracker {
    private final Map<String,SafePoint> locations;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String,SafePoint> getLocations(){
        return this.unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return this.locations.get(id);
    }

    public void setLocation(String id,int x,int y){
        if(!this.locations.containsKey(id)){
            throw new IllegalArgumentException("Invalid vehicle car~~"+id);
        }
        this.locations.get(id).set(x,y);
    }
}
