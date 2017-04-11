package com.github.siemen.zenofdesignpattern.flyweight;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 登录信息
 */
public class SignInfo {

    private String id;
    private String location;
    private String subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
