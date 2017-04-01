package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * 宝马车模型
 */
public class BmwModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("宝马启动~");
    }

    @Override
    protected void stop() {
        System.out.println("宝马停止~");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马引擎轰鸣~");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣喇叭~");
    }
}
