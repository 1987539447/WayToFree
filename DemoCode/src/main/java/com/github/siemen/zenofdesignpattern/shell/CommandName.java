package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */


/**
 * 抽象命令类 - 责任链结点
 * 模板方法
 */
public abstract class CommandName {

    private CommandName nextOperator;

    public final String handleMessage(CommandVO vo){
        String result  = "";
        if(vo.getParam().isEmpty() || vo.getParam().contains(this.getOperateParam())){//需要本节点处理的
            result = this.echo(vo);
        }else{
            if(this.nextOperator != null){
                result = this.nextOperator.handleMessage(vo);
            }else{
                result = "命令无法执行";
            }
        }
        return result;
    }

    public void setNextOperator(CommandName operator){
        this.nextOperator = operator;
    }

    protected abstract String echo(CommandVO vo);

    protected abstract String getOperateParam();
}
