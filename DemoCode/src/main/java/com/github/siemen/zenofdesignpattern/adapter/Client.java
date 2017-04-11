package com.github.siemen.zenofdesignpattern.adapter;
/**
 * Created by Zhan on 2017-04-05.
 */

/**
 * 调用类
 */
public class Client {
    public static void main(String[] args) {
/*        IUserInfo user = new OuterUserInfo();
        for (int i = 0; i < 11; i++) {
            user.getOfficeTel();
        }*/

        IUserInfo user = new OutUserInfo(new OutUserBaseInfo(),new OutUserOfficeInfo());
        for (int i = 0; i < 11; i++) {
            user.getUserName();
            user.getOfficeTel();
        }
    }
}
