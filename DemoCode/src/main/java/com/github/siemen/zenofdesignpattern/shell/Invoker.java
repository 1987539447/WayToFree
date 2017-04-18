package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

/**
 * 命令分发类-命令模式
 */
public class Invoker {

    public String exec(String commandStr){

        String result = "";
        CommandVO vo = new CommandVO(commandStr);
        if(CommandEnum.getNames().contains(vo.getCommandName())){
            String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
            Command command;
            try {
                command = (Command) Class.forName(className).newInstance();
                result = command.execute(vo);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            result = "命令无法执行";
        }

        return result;
    }
}
