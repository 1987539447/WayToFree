package com.github.siemen.jdk8;

/**
 * Created by Zhan on 2017/2/28 0028.
 * 接口默认方法测试
 */
public class TestDefaultMethod {


    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int i) {
                return sqrt(i*100);
            }
        };
        //Formula formula = (a) -> sqrt(i*100); //不能访问默认接口方法

        System.out.println(formula.calculate(3));
    }
}
