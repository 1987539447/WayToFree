package com.github.siemen.effective.singleton;

import java.io.Serializable;

/**
 * Created by Zhan on 2017/3/22 0022.
 * 不能抗序列化，需要实现readResolve方法
 * 不能抗反射攻击，通过反射修改访问权限来调用私有构造器
 */
public class Elvis implements Serializable{


/*    public static final  Elvis INSTANCE = new Elvis();

    private String des;

    private Elvis(){
        this.des = "elvis";
    }
    */

/*    private static final  Elvis INSTANCE = new Elvis();

    private String des;

    private Elvis(){
        this.des = "elvis";
    }

    public static Elvis getInstance(){
        return INSTANCE;
    }*/


    private static final  Elvis INSTANCE = new Elvis();

    transient private String des;

    private Elvis(){
        this.des = "elvis";
    }
    public String getDes(){
        return  this.des;
    }

    public static Elvis getInstance(){
        return INSTANCE;
    }

    private Object readResovle(){
        return INSTANCE;
    }


}
