package com.github.siemen.zenofdesignpattern.command;

/**
 * Created by Zhan on 2017-04-01.
 */
public abstract class Command {
    protected  Group rg = new RequirementGroup();
    protected  Group pg = new PageGroup();
    protected  Group cg = new CodeGroup();
    protected final Group gp;

    public Command(Group group){
        this.gp = group;
    }

    public abstract void execute();
}
