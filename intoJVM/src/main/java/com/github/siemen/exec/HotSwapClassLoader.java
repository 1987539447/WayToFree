package com.github.siemen.exec;
/**
 * Created by Zhan on 2017-05-12.
 */

/**
 * 类加载器
 */
public class HotSwapClassLoader extends ClassLoader {

    //正常情况下都委托给父类加载
    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    //提供加载字节码方法，转换为Class
    //显示调用loadByte才加载指定类，虚拟机调用时仍为派给双亲加载
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
