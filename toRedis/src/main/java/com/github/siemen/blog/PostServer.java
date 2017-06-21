package com.github.siemen.blog;
/**
 * Created by Zhan on 2017-06-09.
 */

import com.github.siemen.util.Const;
import redis.clients.jedis.Jedis;

/**
 * 文章服务
 */
public class PostServer {
    private static final String REDIS_HOST = "119.23.74.153";
    private static final int REDIS_PORT = 6379;
    private static final String REDIS_PASS = "siemen";
    private static final Jedis JEDIS = new Jedis(REDIS_HOST,REDIS_PORT);
    static {
        JEDIS.auth(REDIS_PASS);
        JEDIS.select(1);
    }

    //获取管理员
    public String getAdmin() {
        return JEDIS.get(Const.ADMIN_KEY);
    }
    //设置管理员
    public boolean setAdmin(String admin) {
        String status = JEDIS.set(Const.ADMIN_KEY,admin);
        if("OK".equals(status)){
            return true;
        }
        System.out.println(status);
        return false;
    }
}
