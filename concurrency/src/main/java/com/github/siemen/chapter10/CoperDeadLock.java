package com.github.siemen.chapter10;
/**
 * Created by Zhan on 2017-06-29.
 */


import java.util.HashSet;
import java.util.Set;

/**
 * 协作死锁
 * 程序没有显式的请求多个锁，但在加锁方法中调用对方的加锁方法
 * A:执行setlocation加锁，到达目的地，调用dispatcher.notifyAvailable，请求锁
 * B:执行getImage加锁，调用taxi.getLocation，请求锁
 */
public class CoperDeadLock {

    class Taxi {
        private Point location,destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation(){
            return this.location;
        }

        public synchronized void setLocation(Point location){
            this.location = location;
            if(location.equals(this.destination)){
                dispatcher.notifyAvailable(this);//持有锁同时调用协作对象的加锁方法
            }
        }

    }

    class Dispatcher {

        private final Set<Taxi> taxis;
        private final Set<Taxi> avaliableTaxis;

        public Dispatcher() {
            this.taxis = new HashSet<>();
            this.avaliableTaxis = new HashSet<>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            this.avaliableTaxis.add(taxi);
        }

        public synchronized Image getImage(){
            Image image = new Image();
            for (Taxi taxi : taxis) {
                image.drawMarker(taxi.getLocation());//持有锁同时调用协作对象的加锁方法
            }
            return image;
        }
    }

    class Point{}
    class Image{
        //绘制taxi位置地图
        public void drawMarker(Point point) {

        }
    }
}
