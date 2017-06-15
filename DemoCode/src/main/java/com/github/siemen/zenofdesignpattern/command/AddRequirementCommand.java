package com.github.siemen.zenofdesignpattern.command;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 新增需求
 */
public class AddRequirementCommand extends Command {

    public AddRequirementCommand(){
        this(new RequirementGroup());
    }

    public AddRequirementCommand(Group group) {
        super(group);
    }

    @Override
    public void execute() {
        super.rg.find();
        super.pg.find();
        super.cg.find();
        super.rg.add();
        super.cg.add();
        super.pg.add();
        super.rg.plan();
        super.cg.plan();
    }
}
