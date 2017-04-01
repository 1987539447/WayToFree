package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

import java.util.List;

/**
 * 车辆模型
 */
public abstract class CarModel {

    private List<String> sequence;
    /**基本方法*/
    protected abstract void start();
    protected abstract void stop();
    protected abstract void engineBoom();
    protected abstract void alarm();
    /**模板方法-整体算法框架*/
    public void run(){
        for (String action : sequence) {
            switch (action) {
                case "START":
                    this.start();
                    break;
                case "STOP":
                    this.stop();
                    break;
                case "ALARM":
                    this.alarm();
                    break;
                case "ENGINE":
                    this.engineBoom();
                    break;
            }
        }
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }

    public void setSequence(List<String> sequence){
        this.sequence = sequence;
    }
}
