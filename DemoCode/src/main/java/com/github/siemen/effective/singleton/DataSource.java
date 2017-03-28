package com.github.siemen.effective.singleton;

import java.io.FileInputStream;

/**
 * Created by Zhan on 2017/3/22 0022.
 * 线程安全
 * 抗序列化
 * 抗反射
 */
public enum DataSource {
    INSTACNE;
    private DataSource(){
        this.des = "jdbc";
    }
    public String getDes(){
        return  this.des;
    }
    private  String des;
}
