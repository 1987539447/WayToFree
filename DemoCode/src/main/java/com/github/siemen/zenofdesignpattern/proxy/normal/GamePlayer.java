package com.github.siemen.zenofdesignpattern.proxy.normal;
/**
 * Created by Zhan on 2017-03-31.
 */

/**
 * 玩家类
 */
public class GamePlayer implements IGamePlayer {

    private String name;

    public GamePlayer(IGamePlayer proxy,String name) throws Exception {
        if(proxy == null){
            throw new Exception("不能创建真实角色");
        }
        this.name = name;
    }

    @Override
    public void login(String user, String pass) {
        System.out.println("登录名为:"+user+"的用户"+this.name+"登录成功");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name+"正在打BOSS~");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name+"又升了一级~");
    }
}
