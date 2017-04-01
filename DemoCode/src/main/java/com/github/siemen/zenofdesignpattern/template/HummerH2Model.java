package com.github.siemen.zenofdesignpattern.template;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * H2模型实现
 */
public class HummerH2Model extends HummerModel{
    @Override
    protected void start() {
        System.out.println("悍马H2启动~");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H2停止~");
    }

    @Override
    protected void enginBoom() {
        System.out.println("悍马H2引擎轰鸣~");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H2鸣喇叭~");
    }

    @Override
    protected boolean isAlarm() {
        return false;
    }
}
