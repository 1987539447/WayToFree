package com.github.siemen.blog.service.imp;
/**
 * Created by Zhan on 2017-06-12.
 */

import com.alibaba.fastjson.JSON;
import com.github.siemen.blog.model.Admin;
import com.github.siemen.blog.model.Blog;
import com.github.siemen.blog.model.MAV;
import com.github.siemen.blog.service.IBlogService;
import com.github.siemen.util.Const;
import redis.clients.jedis.Jedis;


/**
 * 博客管理服务
 */
public class BlogService implements IBlogService {

    private static final String REDIS_HOST = "119.23.74.153";
    private static final int REDIS_PORT = 6379;
    private static final String REDIS_PASS = "siemen";
    private static final Jedis JEDIS = new Jedis(REDIS_HOST,REDIS_PORT);
    static {
        JEDIS.auth(REDIS_PASS);
        JEDIS.select(1);
    }

    private static final BlogService instance = new BlogService();

    private BlogService(){}

    public static IBlogService getInstance() {
        return instance;
    }

    /**
     * 显示功能菜单
     * */
    @Override
    public MAV showMenu(){
        return new MAV(null,Const.PAGE_MENU);
    }

    /**
     * 管理员设置显示
     * */
    @Override
    public MAV getAdmin(){
        return new MAV(new Admin(JEDIS.get(Const.ADMIN_KEY)),null);
    }

    @Override
    public MAV setAdmin(String admin) {
        if(admin == null || "".equals(admin)){
            return new MAV(null,Const.PAGE_ADMIN);
        }
        JEDIS.set(Const.ADMIN_KEY,admin);
        return null;
    }

    @Override
    public MAV post(Blog blog) {
        long id = JEDIS.incr(Const.POST_COUNT);
        blog.setId(id);
        String key = "post:"+id+":data";
        System.out.println(JSON.toJSONString(blog));
        JEDIS.set(key, JSON.toJSONString(blog));
        return new MAV("发布成功，文章ID："+id,Const.PAGE_MSG);
    }

    @Override
    public MAV viewBlog(String postId) {
        if(postId == null || "".equals(postId)){
            return new MAV("文章ID不能为空",Const.PAGE_MSG);
        }
        String blogStr = JEDIS.get(getPostKey(postId));
        return new MAV(JSON.parseObject(blogStr,Blog.class),null);
    }

    private String getPostKey(String postId) {
        return "post:"+postId+":data";
    }
}
