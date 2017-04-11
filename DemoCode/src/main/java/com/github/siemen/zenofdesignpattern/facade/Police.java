package com.github.siemen.zenofdesignpattern.facade;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 警察类-扩展对邮件检查
 */
public class Police {
    public void checkLetter(ILetterProcess letterProcess){
        System.out.println(letterProcess+"邮件已经检查过了~");
    }
}
