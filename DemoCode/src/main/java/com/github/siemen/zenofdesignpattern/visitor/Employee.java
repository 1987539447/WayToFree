package com.github.siemen.zenofdesignpattern.visitor;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 职工抽象类
 */
public abstract class Employee {

    private static final int MALE = 1;
    private static final int FEMALE = 0;



    private int salary;
    private String name;
    private int sex;

    protected  abstract void accept(IVisitor visitor);

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary(int coefficient) {
        return salary * coefficient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
