package com.github.siemen.zenofdesignpattern.facade;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 写信流程实现
 */
public class LetterProcessImp implements ILetterProcess {
    @Override
    public void writeContext(String context) {
        System.out.println("写信的内容："+context);
    }

    @Override
    public void fillEnvelope(String address) {
        System.out.println("写信封地址："+address);
    }

    @Override
    public void letterIntoEnvelope() {
        System.out.println("邮件投入邮箱~");
    }

    @Override
    public void sendLetter() {
        System.out.println("投递邮件~");
    }
}
