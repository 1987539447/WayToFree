package com.github.siemen.zenofdesignpattern.flyweight;
/**
 * Created by Zhan on 2017-04-11.
 */

/**
 * 客户端类
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            String subject = "科目"+i;
            for (int j = 1; j < 5; j++) {
                String key = subject + "考试地点"+j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfoFactory.getSignInfo("科目1考试地点1");
    }
}
