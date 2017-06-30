package com.github.siemen.zenofdesignpattern.chain;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 处理类抽象
 */
public abstract class Handler {

    public final static int FATHER_LEVEL_REQUSET = 1;
    public final static int HUSBAND_LEVEL_REQUSET = 2;
    public final static int SON_LEVEL_REQUSET = 3;

    private int level = 0;

    private Handler nextHandler;

    public Handler(int level){
        this.level = level;
    }

    public final void HandleMessage(IWomen women){
        if(women.getType() == this.level){
            this.response(women);
        }else{
            if(this.nextHandler != null){
                this.nextHandler.HandleMessage(women);
            }else{
                System.out.println("------没地方请示，按不同意处理------");
            }
        }
    }
    public void setNext(Handler handler){
        this.nextHandler = handler;
    }

    public abstract void response(IWomen women);
}
