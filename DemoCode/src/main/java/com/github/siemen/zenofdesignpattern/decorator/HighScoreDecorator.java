package com.github.siemen.zenofdesignpattern.decorator;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 增加报告最高分装饰
 */
public class HighScoreDecorator extends Decorator {


    public HighScoreDecorator(SchoolReport report) {
        super(report);
    }

    private void reportHighScore(){
        System.out.println("成绩最高分：语文75，数学78，自然80");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
