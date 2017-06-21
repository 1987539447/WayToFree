package com.github.siemen.blog.model;
/**
 * Created by Zhan on 2017-06-12.
 */

/**
 * 管理员
 */
public class Admin {
    private String name;

    public Admin() {
    }
    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
