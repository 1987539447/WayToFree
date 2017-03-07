package com.github.siemen.reflect;

import java.util.Date;

/**
 * Created by Zhan on 2017/3/6 0006.
 */
public class ClassType {


    public static void main(String[] args) throws Exception {
        Class c1 = Date.class;
        System.out.println("c1- class name---"+c1.getName());
        Date now = new Date();
        Class c2 = now.getClass();
        if(c1.equals(c2)){
            System.out.println("---the same class equal--");
        }
        if(c1 == c2){
            System.out.println("---the same class == --");
        }

        Class c3 = Class.forName("java.lang.String");
        String vString = (String) c3.newInstance();
        System.out.println("---new instance--"+vString);

    }
}
