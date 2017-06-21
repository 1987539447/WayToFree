package com.github.siemen.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class JedisUtil {
    private static JedisPool redisPool = null;
    //public static Logger logger = Logger.getLogger(com.github.siemen.util.JedisUtil.class);
    static {
        try{

            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("'")));
            //Properties properties = PropertyUtil.getPropertie("redis.properties");
            JedisPoolConfig config = new JedisPoolConfig();
            // 最大连接数：能够同时建立的“最大链接个数”
            config.setMaxTotal(Integer.valueOf(properties.getProperty("maxTotal")));
            // 最大空闲数：空闲链接数大于maxIdle时，将进行回收
            config.setMaxIdle(Integer.valueOf(properties.getProperty("maxIdle")));
            // 使用连接时，检测连接是否成功
            config.setTestOnBorrow(Boolean.valueOf(properties
                    .getProperty("testOnBorrow")));
            // 返回连接时，检测连接是否成功
            config.setTestOnReturn(Boolean.valueOf(properties
                    .getProperty("testOnReturn")));
            // 密码
            String auth = properties.getProperty("auth");
            String host = properties.getProperty("host");
            int port = Integer.valueOf(properties.getProperty("port"));
            // 最大等待时间：单位ms
            int timeout = Integer.valueOf(properties.getProperty("maxWait"));
            redisPool = new JedisPool(config, host, port, timeout, auth);
        }catch (Exception e) {
            //logger.fatal("初始化redis出错",e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static JedisPool getRedisPool() {
        return redisPool;
    }

    public static Jedis getJedis(){
        return redisPool.getResource();
    }
    //一定要记得把redis的连接释放掉
    public static void returnJedis(Jedis jedis){
        jedis.close();
        //redisPool.returnResource(jedis);
    }
}