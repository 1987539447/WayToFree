package com.github.siemen;
/**
 * Created by Zhan on 2017-06-09.
 */

import redis.clients.jedis.Jedis;

/**
 * 测试jedis
 */
public class StartUp {

    private static final String REDIS_HOST = "119.23.74.153";
    private static final int REDIS_PORT = 6379;
    private static final Jedis JEDIS = new Jedis(REDIS_HOST,REDIS_PORT);
    private static final String REDIS_PASS = "siemen";

    public static void main(String[] args) {
        JEDIS.auth(REDIS_PASS);
        //JEDIS.select(1);
        //setGet();
        incr();
    }

    private static void incr(){
        long result = JEDIS.incr("users:count");
        System.out.println(result);
    }

    private static void setGet(){
        JEDIS.set("redis","work");
        System.out.println(JEDIS.get("abcd"));
    }
}
