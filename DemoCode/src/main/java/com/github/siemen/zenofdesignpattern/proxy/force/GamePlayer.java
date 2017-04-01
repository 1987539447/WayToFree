package com.github.siemen.zenofdesignpattern.proxy.force;
/**
 * Created by Zhan on 2017-03-31.
 */


/**
 * 玩家类
 */
public class GamePlayer implements IGamePlayer {

    private String name;
    private IGamePlayer proxy;

    public GamePlayer(String name){
        this.name = name;
    }

    @Override
    public void login(String user, String pass) {
        if(this.isProxy()){
            System.out.println("登录名为:"+user+"的用户"+this.name+"登录成功");
        }else{
            System.out.println("请使用指定代理对象");
        }

    }

    @Override
    public void killBoss() {
        if(this.isProxy()){
            System.out.println(this.name+"正在打BOSS~");
        }else{
            System.out.println("请使用指定代理对象");
        }

    }

    @Override
    public void upgrade() {
        if(this.isProxy()){
            System.out.println(this.name+"又升了一级~");
        }else{
            System.out.println("请使用指定代理对象");
        }

    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy() {
        return this.proxy != null;
    }
}
