package com.github.siemen.zenofdesignpattern.decorator;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 增加排名装饰
 */
public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport report) {
        super(report);
    }

    private void reportSort(){
        System.out.println("我的排名是38名....");
    }

    @Override
    public void report() {
        this.reportSort();
        super.report();
    }
}
