package com.github.siemen.zenofdesignpattern.proxy.force;
/**
 * Created by Zhan on 2017-03-31.
 */


/**
 * 玩家代理类
 */
public class GamePlayerProxy implements IGamePlayer,IProxy {

    IGamePlayer player;

    public GamePlayerProxy(IGamePlayer player){
        this.player = player;
    }

    @Override
    public void login(String user, String pass) {
        this.player.login(user,pass);
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
        this.count();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void count() {
        System.out.println("升级总费用：100元");
    }
}
