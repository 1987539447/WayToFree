package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 外部职工适配类
 * 类适配器
 */
public class OuterUserInfo extends OutUser implements IUserInfo {


    @Override
    public String getUserName() {
        String usenName = super.getUserBaseInfo().get("userName");
        System.out.println("----职工姓名---"+usenName);
        return usenName;
    }

    @Override
    public String getOfficeTel() {
        String officeTel = super.getOfficeInfo().get("officeTel");
        System.out.println("-------办公室电话-----"+officeTel);
        return officeTel;
    }
}
