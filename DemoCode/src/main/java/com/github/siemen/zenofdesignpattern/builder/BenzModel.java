package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * 奔驰模型
 */
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰启动~");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰停止~");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰引擎轰鸣~");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰鸣喇叭~");
    }
}
