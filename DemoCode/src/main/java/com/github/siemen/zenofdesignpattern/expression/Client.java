package com.github.siemen.zenofdesignpattern.expression;
/**
 * Created by Zhan on 2017-04-10.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解释器调用类
 */
public class Client {
    public static void main(String[] args) {
        String expStr = getExpStr();
        Map<String,Integer> var = getValue(expStr);
        Calculator cal = new Calculator(expStr);
        System.out.println("运算结果为："+expStr+"="+cal.run(var));
    }

    private static Map<String,Integer> getValue(String expStr) {
        Map<String,Integer> var = new HashMap<>();
        Scanner in = new Scanner(System.in);
        for (char ch : expStr.toCharArray()) {
            if(ch != '+' && ch !='-'){
                if(!var.containsKey(String.valueOf(ch))){
                    System.out.println("请输入"+ch+"的值：");
                    int value = in.nextInt();
                    var.put(String.valueOf(ch),value);
                }
            }
        }
        return var;
    }

    private static String getExpStr() {
        System.out.println("请输入表达式：");
        return (new Scanner(System.in).nextLine());
    }
}
