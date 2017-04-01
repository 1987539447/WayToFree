package com.github.siemen.zenofdesignpattern.prototype;
/**
 * Created by Zhan on 2017-04-01.
 */

/**
 * 邮件原型类
 */
public class Mail implements Cloneable {

    private String receiver;
    private String subject;
    private String appellation;
    private String contxt;
    private String tail;

    public Mail(AdvTemplate template){
        this.subject = template.getAdvSubject();
        this.contxt = template.getAdvContext();
    }
    @Override
    public Mail clone(){
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContxt() {
        return contxt;
    }

    public void setContxt(String contxt) {
        this.contxt = contxt;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
