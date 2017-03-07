package com.github.siemen.reflect;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zhan on 2017/3/6 0006.
 */
public class ReflectClass {

    public static void main(String[] args) throws ClassNotFoundException {

        printClass("com.github.siemen.generics.Pair");


    }

    public static void printClass(String clazzName) throws ClassNotFoundException {

        Class clazz = Class.forName(clazzName);
        printClass(clazz);
    }

    public static void printClass(Class clazz){

        Class parent = clazz.getSuperclass();
        String modifers = Modifier.toString(clazz.getModifiers());
        if(modifers.length()>0){
            System.out.print(modifers+" ");
        }
        System.out.print("class "+clazz.getName());

        if(parent != null && parent != Object.class){
            System.out.print(" extends "+parent.getName());
        }
        System.out.print(" {\n");

        printConstructors(clazz);
        System.out.println();

        printMethods(clazz);
        System.out.println();

        printFiedls(clazz);

    }

    public static void printFiedls(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String type = field.getType().getTypeName();
            String name = field.getName();
            String modifer = Modifier.toString(field.getModifiers());
            if(modifer.length()>0) {
                System.out.print(modifer+" ");
            }
            System.out.println(type+" "+name+";");
        }
    }

    public static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            String returnType = method.getReturnType().getTypeName();
            String modifer = Modifier.toString(method.getModifiers());
            if(modifer.length()>0){
                System.out.print(modifer+" ");
            }
            System.out.print(returnType+" "+name+"(");
            Parameter[] parameters = method.getParameters();
            printParams(parameters);
            System.out.println(");");

        }
    }

    public static void printConstructors(Class clazz) {
        Constructor[] construnctors = clazz.getDeclaredConstructors();
        String name;
        String modifer;
        for (Constructor construnctor : construnctors) {
            name = construnctor.getName();
            modifer = Modifier.toString(construnctor.getModifiers());
            if(modifer.length()>0){
                System.out.print(modifer+" ");
            }
            System.out.print(name+"(");
            Parameter[] params = construnctor.getParameters();
            printParams(params);
            System.out.println(");");
        }
    }

    public static void printParams(Parameter[] params){
        for (int i = 0; i < params.length; i++) {
            if(i>0){
                System.out.print(", ");
            }
            System.out.print(params[i].getType().getTypeName()+" "+params[i].getName());
        }
    }
}
