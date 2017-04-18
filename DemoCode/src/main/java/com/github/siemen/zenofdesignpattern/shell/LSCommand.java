package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

/**
 * ls命令
 */
public class LSCommand extends Command {
    @Override
    public String execute(CommandVO vo) {
        CommandName head = super.buildChain(AbstractLS.class).get(0);
        return head.handleMessage(vo);
    }
}
