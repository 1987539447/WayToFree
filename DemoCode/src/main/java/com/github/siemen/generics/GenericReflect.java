package com.github.siemen.generics;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Zhan on 2017/3/7 0007.
 * 获取反射中泛型信息
 * 超类限定，子类限定
 */
public class GenericReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        printClass("com.github.siemen.generics.Pair");
        printMethod("com.github.siemen.generics.Pair");

    }

    public static void printClass(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        printClass(clazz);
    }
    public static void printClass(Class clazz){

        System.out.print(clazz);
        printTypes(clazz.getTypeParameters(),"<",",",">",true);
        Type superType = clazz.getGenericSuperclass();
        if(superType != null){
            System.out.print(" extends ");
            printType(superType,false);
        }
        printTypes(clazz.getGenericInterfaces()," implements",",","",false);
        System.out.println();
    }


    public static void printMethod(String className) throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        printMethod(clazz);
    }
    public static void printMethod(Class clazz){

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            printMethod(method);
        }
    }
    public static void printMethod(Method method){
        String name = method.getName();
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" ");
        printTypes(method.getTypeParameters(),"<",",",">",true);
        printType(method.getGenericReturnType(),false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(method.getGenericParameterTypes(),"",",","",false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types,String pre,String sep,String suf,boolean isDefinition){
        if(pre.equals(" extends ") || Arrays.equals(types,new Type[]{Object.class})){
            return;
        }
        if(types.length>0){
            System.out.print(pre);
        }
        for (int i = 0; i < types.length; i++) {
            if(i >0){
                System.out.print(sep);
            }
            printType(types[i],isDefinition);
            if(types.length >0){
                System.out.print(suf);
            }
        }

    }

    public static void printType(Type type,boolean isDefiniton){
        if(type instanceof Class){
            System.out.print(((Class) type).getName());
        }else if(type instanceof TypeVariable){
            System.out.print(((TypeVariable) type).getName());
            if(isDefiniton){
                printTypes(((TypeVariable) type).getBounds()," extends "," & ","",false);
            }
        }else if(type instanceof WildcardType){
            System.out.print(" ? ");
            printTypes(((WildcardType) type).getUpperBounds()," extends "," & ",",",false);
            printTypes(((WildcardType) type).getLowerBounds()," super "," & ","",false);
        }else if(type instanceof ParameterizedType){
            if(((ParameterizedType) type).getOwnerType() != null){
                printType(((ParameterizedType) type).getOwnerType(),false);
                System.out.print(".");
            }
        }else if(type instanceof GenericArrayType){
            System.out.print("");
            printType(((GenericArrayType) type).getGenericComponentType(),false);
            System.out.print("[]");
        }
    }
}
