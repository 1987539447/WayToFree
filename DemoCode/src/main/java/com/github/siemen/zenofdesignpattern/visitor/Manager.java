package com.github.siemen.zenofdesignpattern.visitor;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 *经理类
 */
public class Manager extends Employee{

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    protected void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
