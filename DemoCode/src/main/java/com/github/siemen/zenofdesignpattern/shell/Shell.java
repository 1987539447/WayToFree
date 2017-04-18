package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

import java.util.Scanner;

/**
 * 客户端调用类
 * 模拟Linux下命令ls
 * 设计模式：模板方法模式-责任链模式-命令模式
 */
public class Shell {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("#");
            String command = scanner.nextLine();
            if(command.equals("quit")||command.equals("exit")){
                return;
            }
            System.out.println(invoker.exec(command));
        }
    }
}
