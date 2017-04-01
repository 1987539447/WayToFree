package com.github.siemen.zenofdesignpattern.prototype;
/**
 * Created by Zhan on 2017-04-01.
 */

import java.util.Random;

/**
 * 邮件发送客户端
 */
public class SendMail {
    private static int MAX_COUNT = 6;
    public static void main(String[] args) {
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        for (int i = 0; i < MAX_COUNT; i++) {
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandString(5)+"先生（女生）");
            cloneMail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
            sendMail(cloneMail);
        }

    }

    private static void sendMail(Mail mail) {
        System.out.println("标题："+ mail.getSubject()+"\t收件人："+mail.getReceiver()+"\t...发送成功~");
    }

    private static String getRandString(int len) {
        StringBuilder buf = new StringBuilder();
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            buf.append(source.charAt(random.nextInt(source.length())));
        }
        return  buf.toString();
    }
}
