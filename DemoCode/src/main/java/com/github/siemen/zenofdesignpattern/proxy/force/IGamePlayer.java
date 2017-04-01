package com.github.siemen.zenofdesignpattern.proxy.force;

/**
 * Created by Zhan on 2017-03-31.
 */
public interface IGamePlayer {
    void login(String user, String pass);
    void killBoss();
    void upgrade();
    IGamePlayer getProxy();

}
