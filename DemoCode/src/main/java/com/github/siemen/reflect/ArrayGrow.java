package com.github.siemen.reflect;

import java.lang.reflect.Array;

/**
 * Created by Zhan on 2017/3/7 0007.
 */
public class ArrayGrow {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        a = (int[]) arrayGrow(a);
        printArray(a);
        String[] b = {"jack","lily","rose"};
        b = (String[]) arrayGrow(b);
        printArray(b);

    }
    public static Object arrayGrow(Object object){
        Class clazz = object.getClass();
        if(!clazz.isArray()){
            return null;
        }
        Class type = clazz.getComponentType();
        int length = Array.getLength(object);
        int newLength = length * 11/10 +10;
        Object newArray = Array.newInstance(type,newLength);
        System.arraycopy(object,0,newArray,0,length);
        return newArray;
    }


    public static void printArray(Object object){

        Class clazz = object.getClass();
        if(!clazz.isArray()){
            return;
        }
        int length = Array.getLength(object);
        Class type = clazz.getComponentType();
        System.out.print(type.getName()+"["+length+"]{");
        for (int i = 0; i < length; i++) {
            System.out.print(Array.get(object,i)+" ");
        }
        System.out.println("}");
    }
}
