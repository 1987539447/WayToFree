package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 对象适配
 */
public class OutUserInfo implements IUserInfo {

    private final IOutUserBaseInfo baseInfo;
    private final IOutUserOfficeInfo officeInfo;

    public OutUserInfo(IOutUserBaseInfo baseInfo, IOutUserOfficeInfo officeInfo){
        this.baseInfo = baseInfo;
        this.officeInfo = officeInfo;
    }

    @Override
    public String getUserName() {
        String usenName = this.baseInfo.getUserBaseInfo().get("userName");
        System.out.println("----职工姓名---"+usenName);
        return usenName;
    }

    @Override
    public String getOfficeTel() {
        String officeTel = this.officeInfo.getOfficeInfo().get("officeTel");
        System.out.println("----办公电话---"+officeTel);
        return officeTel;
    }
}
