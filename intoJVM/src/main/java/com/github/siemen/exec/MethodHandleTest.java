package com.github.siemen.exec;
/**
 * Created by Zhan on 2017-05-11.
 */

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * 测试MethodHandle
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println(s+"--ClassA");
        }
    }

    public static void main(String[] args) throws Throwable {
        //obj类型不确定
        Object obj = System.currentTimeMillis() %2 == 0 ? System.out : new ClassA();

        getPrintlnMH(obj).invokeExact("siemen");

    }

    private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {

        //MethodType 方法类型，包含方法返回值和参数
        MethodType mt = MethodType.methodType(void.class,String.class);

        //lookup查找符合条件的虚方法句柄
        return lookup().findVirtual(receiver.getClass(),"println",mt).bindTo(receiver);
    }
}
