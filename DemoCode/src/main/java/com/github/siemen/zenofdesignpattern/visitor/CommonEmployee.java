package com.github.siemen.zenofdesignpattern.visitor;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 普通职工
 */
public class CommonEmployee extends Employee {

    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    protected void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
