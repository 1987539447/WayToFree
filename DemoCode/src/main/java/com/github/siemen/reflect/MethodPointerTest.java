package com.github.siemen.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Zhan on 2017/3/16 0016.
 * 反射方法调用
 */
public class MethodPointerTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method square = MethodPointerTest.class.getDeclaredMethod("square",double.class);
        Method sqrt = Math.class.getDeclaredMethod("sqrt",double.class);
        printTable(1,10,10,square);
        printTable(1,10,10,sqrt);
    }

    public static double square(double x){
        return x*x;
    }
    public static void printTable(double from, double to, int step, Method method) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method);
        double dx = (to - from)/(step-1);
        for (double x = from; x < to; x += dx) {
            double y = (double)method.invoke(null,x);//静态方法传入对象null,否则传入实例对象
            System.out.printf("%10.4f | %10.4f%n",x,y);
        }
    }
}
