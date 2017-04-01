package com.github.siemen.zenofdesignpattern.proxy.normal;
/**
 * Created by Zhan on 2017-03-31.
 */

/**
 * 玩家代理类
 */
public class GamePlayerProxy implements IGamePlayer{

    IGamePlayer player;

    public GamePlayerProxy(String name) throws Exception {
        this.player = new GamePlayer(this,name);
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
    }
}
