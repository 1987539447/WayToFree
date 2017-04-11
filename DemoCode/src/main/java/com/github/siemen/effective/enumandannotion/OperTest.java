package com.github.siemen.effective.enumandannotion;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 四则运算测试
 */
public class OperTest {
    public static void main(String[] args) {
        double x = 1.2;
        double y = 2.3;
        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",x,operation,y,operation.apply(x,y));
        }
    }
}
