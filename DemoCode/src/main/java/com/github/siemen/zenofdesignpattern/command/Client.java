package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 客户类
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        System.out.println("---------增加需求---------");
        Command command = new AddRequirementCommand();
        invoker.setCommand(command);
        invoker.action();
    }
}
