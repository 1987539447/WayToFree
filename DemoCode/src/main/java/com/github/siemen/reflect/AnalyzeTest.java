package com.github.siemen.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by Zhan on 2017/3/7 0007.
 */
public class AnalyzeTest {

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
            for (int i = 0; i < 10 ; i++) {
                squares.add(i*i);
            }
            System.out.println(new AnalyzeTest().toString(squares));

    }

    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object object){

        //is null
        if(object == null) {
            return  "null";
        }
        //circle ref
        if(visited.contains(object)){
            return "...";
        }
        Class clazz = object.getClass();
        //is String
        if(clazz == String.class) {
            return (String) object;
        }
        if(clazz.isArray()){//is Array loop
            String result = clazz.getComponentType()+"[]{";
            for (int i = 0; i < Array.getLength(object); i++) {
                if(i>0){
                    result +=",";
                }
                Object element = Array.get(object,i);
                if(clazz.getComponentType().isPrimitive()){//primit
                    result += element;
                }else{//recall
                    result += toString(element);
                }
            }
            return result + "}";
        }
        String result = clazz.getName();
        do {
            result +="[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field field : fields) {
                if (!(Modifier.isStatic(field.getModifiers()))){
                    if (!result.endsWith("[")){
                        result += ",";
                    }
                    result += field.getName() + "=";
                    Class type = field.getType();
                    try {
                        Object val = field.get(object);
                        if (type.isPrimitive()){
                            result += val;
                        }else{
                            result += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            result +="]";
            clazz = clazz.getSuperclass();
        }while (clazz != null);
        return result;
    }
}
