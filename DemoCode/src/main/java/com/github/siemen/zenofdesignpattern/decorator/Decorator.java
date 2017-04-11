package com.github.siemen.zenofdesignpattern.decorator;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 装饰器抽象
 */
public abstract class Decorator extends SchoolReport {

    private SchoolReport report;

    public Decorator(SchoolReport report){
        this.report = report;
    }

    @Override
    public void report() {
        this.report.report();
    }

    @Override
    public void sign(String name) {
        this.report.sign(name);
    }
}
