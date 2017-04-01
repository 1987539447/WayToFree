package com.github.siemen.zenofdesignpattern.proxy.normal;
/**
 * Created by Zhan on 2017-03-31.
 */

import java.util.Date;

/**
 * 普通代理调用
 * 直接使用代理，不使用真实对象
 */
public class NormalProxyClient {
    public static void main(String[] args) throws Exception {
        IGamePlayer proxy = new GamePlayerProxy("张三丰");
        System.out.println("开始时间是："+new Date());
        proxy.login("sanfeng","123");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间是："+new Date());
    }
}
