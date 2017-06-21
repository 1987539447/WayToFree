package com.github.siemen.loadclass;
/**
 * Created by Zhan on 2017-05-10.
 */

/**
 *通过子类引用父类的静态变量，仅触发初始化父类
 * 通过数组定义引用类不会触发初始化，触发对应数组类的初始化
 * 常量在编译阶段进入常量池，不会触发被引用类初始化
 */
public class NotInit {
    public static void main(String[] args) {
        //System.out.println(Sub.value);
        //Super[] sca = new Super[10];
        System.out.println(ConstClass.HELLO);
    }
}
