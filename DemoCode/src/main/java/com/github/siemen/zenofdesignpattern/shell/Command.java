package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 命令类抽象-建立处理链
 */
public abstract class Command {

    public abstract String execute(CommandVO vo);

    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> absClass){
        List<Class> sonClasses = ClassUtil.getSonClass(absClass);
        List<CommandName> commandNameList = new ArrayList<>();
        for (Class sonClazz : sonClasses) {
            CommandName commandName = null;
            try {

                commandName = (CommandName) sonClazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(!commandNameList.isEmpty()){
                commandNameList.get(commandNameList.size() -1).setNextOperator(commandName);
            }
            commandNameList.add(commandName);
        }
        return commandNameList;
    }
}
