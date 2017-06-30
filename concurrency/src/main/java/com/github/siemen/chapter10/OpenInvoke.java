package com.github.siemen.chapter10;
/**
 * Created by Zhan on 2017-06-29.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 开放调用重构解决协作对象死锁
 */
public class OpenInvoke {

    class Taxi {
        private Point location,destination;
        private final Dispatcher dispatcher;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation(){
            return this.location;
        }

        /**缩小同步块，释放锁后再去调用对方同步方法*/
        public void setLocation(Point location){
            boolean reachDes = false;
            synchronized (this){
                this.location = location;if(location.equals(this.destination)){
                    reachDes = true;
                }

            }
            if(reachDes){
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

        /**
         * 缩小同步块，释放自身锁后再调用对方同步方法
         * 创建当前数据copy,不锁定整个对象
         * */
        public Image getImage(){
            Image image = new Image();
            Set<Taxi> copy;
            synchronized (this){
                copy = new HashSet<>(taxis);
            }
            for (Taxi taxi : copy) {
                image.drawMarker(taxi.getLocation());
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
