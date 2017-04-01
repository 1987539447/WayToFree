package com.github.siemen.zenofdesignpattern.template;
/**
 * Created by Zhan on 2017-03-30.
 */

/**
 * 模板测试
 */
public class HummerTest {
    public static void main(String[] args) {
        HummerH1Model h1 = new HummerH1Model();
        h1.setAlarmFlag(true);
        HummerModel h2 = new HummerH2Model();
        System.out.println("运行H1型号悍马~~~~~~~");
        h1.run();
        System.out.println("运行H2型号悍马~~~~~~~");
        h2.run();
    }
}
