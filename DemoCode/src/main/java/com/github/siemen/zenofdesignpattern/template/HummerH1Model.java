package com.github.siemen.zenofdesignpattern.template;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * H1模型实现
 */
public class HummerH1Model extends HummerModel {

    private boolean alarmFlag;

    @Override
    protected void start() {
        System.out.println("悍马H1启动~");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H1停止~");
    }

    @Override
    protected void enginBoom() {
        System.out.println("悍马H1引擎轰鸣~");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣喇叭~");
    }

    @Override
    protected boolean isAlarm() {
        return alarmFlag;
    }

    public void setAlarmFlag(boolean flag){
        this.alarmFlag = flag;
    }
}
