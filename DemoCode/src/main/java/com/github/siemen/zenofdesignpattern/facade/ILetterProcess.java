package com.github.siemen.zenofdesignpattern.facade;

/**
 * Created by Zhan on 2017-04-07.
 * 写信流程抽象接口
 */
public interface ILetterProcess {
    void writeContext(String context);
    void fillEnvelope(String address);
    void letterIntoEnvelope();
    void sendLetter();
}
