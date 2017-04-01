package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 美工组
 */
public class PageGroup implements Group{
    @Override
    public void find() {
        System.out.println("找到美工组~");
    }

    @Override
    public void add() {
        System.out.println("增加页面~");
    }

    @Override
    public void delete() {
        System.out.println("删除页面~");
    }

    @Override
    public void change() {
        System.out.println("修改页面~");
    }

    @Override
    public void plan() {
        System.out.println("页面变更计划~");
    }
}
