package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */


/**
 * 代码组
 */
public class CodeGroup implements Group {
    @Override
    public void find() {
        System.out.println("找到代码组~");
    }

    @Override
    public void add() {
        System.out.println("增加代码~");
    }

    @Override
    public void delete() {
        System.out.println("删除代码~");
    }

    @Override
    public void change() {
        System.out.println("修改代码~");
    }

    @Override
    public void plan() {
        System.out.println("代码变更计划~");
    }
}
