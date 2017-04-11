package com.github.siemen.zenofdesignpattern.decorator;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 查看成绩单签名类
 */
public class Father {

    public static void main(String[] args) {

        SchoolReport report = new FouthGradeSchoolReport();
        report = new HighScoreDecorator(report);
        report = new SortDecorator(report);
        report.report();
        report.sign("张三丰");
    }
}
