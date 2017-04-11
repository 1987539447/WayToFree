package com.github.siemen.zenofdesignpattern.facade;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 现代邮局--写信流程的门面
 */
public class ModenPostOffice {

    ILetterProcess letterProcess = new LetterProcessImp();
    Police police = new Police();
    void sendLetter(String context,String address){
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        police.checkLetter(letterProcess);
        letterProcess.letterIntoEnvelope();
        letterProcess.sendLetter();
    }
}
