package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 需求组
 */
public class RequirementGroup implements Group {

    @Override
    public void find() {
        System.out.println("找到需求组~");
    }

    @Override
    public void add() {
        System.out.println("增加需求~");
    }

    @Override
    public void delete() {
        System.out.println("删除需求~");
    }

    @Override
    public void change() {
        System.out.println("修改需求~");
    }

    @Override
    public void plan() {
        System.out.println("需求变更计划~");
    }
}
