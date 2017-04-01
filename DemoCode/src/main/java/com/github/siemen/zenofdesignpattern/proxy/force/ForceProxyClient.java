package com.github.siemen.zenofdesignpattern.proxy.force;
/**
 * Created by Zhan on 2017-03-31.
 */

import java.util.Date;

/**
 * 强制代理调用类
 */
public class ForceProxyClient {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三丰");
        IGamePlayer proxy = player.getProxy();
        System.out.println("开始时间是："+new Date());
        proxy.login("sanfeng","123");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是："+new Date());
    }
}
