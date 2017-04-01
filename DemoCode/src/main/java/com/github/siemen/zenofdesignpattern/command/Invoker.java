package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 执行类
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }
    public void action(){
        this.command.execute();
    }
}
