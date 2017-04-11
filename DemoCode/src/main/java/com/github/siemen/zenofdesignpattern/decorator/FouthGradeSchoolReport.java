package com.github.siemen.zenofdesignpattern.decorator;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 四年级成绩单
 */
public class FouthGradeSchoolReport extends SchoolReport {
    @Override
    public void report() {
        System.out.println("尊敬的XXX家长：");
        System.out.println("................");
        System.out.println("语文63，数学65，自然67");
        System.out.println("................");
        System.out.println("...........家长签名.....");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名："+name);
    }
}
