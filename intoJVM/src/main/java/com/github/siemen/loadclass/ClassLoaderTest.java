package com.github.siemen.loadclass;
/**
 * Created by Zhan on 2017-05-10.
 */

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试类加载器
 * 自定义类加载器加载的ClassLoaderTest与应用类加载器加载的并不相等
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                }catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = loader.loadClass("com.github.siemen.loadclass.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.github.siemen.loadclass.ClassLoaderTest);
    }
}
