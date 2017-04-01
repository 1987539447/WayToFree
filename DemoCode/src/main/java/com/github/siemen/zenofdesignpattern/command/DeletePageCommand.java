package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 删除页面需求
 */
public class DeletePageCommand extends Command {

    public DeletePageCommand(){
        super(new PageGroup());
    }

    public DeletePageCommand(Group group) {
        super(group);
    }

    @Override
    public void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
