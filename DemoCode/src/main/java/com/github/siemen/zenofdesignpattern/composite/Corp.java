package com.github.siemen.zenofdesignpattern.composite;
/**
 * Created by Zhan on 2017-04-06.
 */

/**
 * 职工抽象类
 */
public abstract class Corp {
    private String name;
    private String position;
    private int salary;

    public Corp(String name ,String position,int salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("姓名：").append(this.name)
                .append("\t 职位：").append(this.position)
                .append("\t 薪水：").append(this.salary);
        return  info.toString();
    }
}
