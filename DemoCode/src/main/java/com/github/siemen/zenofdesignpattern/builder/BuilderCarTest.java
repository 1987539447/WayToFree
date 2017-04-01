package com.github.siemen.zenofdesignpattern.builder;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * 建造测试
 */
public class BuilderCarTest {
    public static void main(String[] args) {
        Director director = new Director();
        CarModel carModel ;
        carModel = director.getBenzModelA();
        carModel.run();
        carModel = director.getBenzModelB();
        carModel.run();
        carModel = director.getBmwModelA();
        carModel.run();
    }
}
