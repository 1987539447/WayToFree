package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 职工类
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("职工姓名：xxx");
        return null;
    }

    @Override
    public String getOfficeTel() {
        System.out.println("办公室电话：XXX");
        return null;
    }
}
