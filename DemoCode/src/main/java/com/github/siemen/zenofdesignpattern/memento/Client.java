package com.github.siemen.zenofdesignpattern.memento;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 客户端类
 */
public class Client {
    public static void main(String[] args) {
        Boy boy = new Boy();
        Caretaker caretaker = new Caretaker();
        boy.setState("心情很好~");
        System.out.println("------------男孩当前状态-------");
        System.out.println(boy.getState());
        caretaker.setMemento(boy.createMemento());
        boy.changeState();
        System.out.println("-----男孩追女孩后状态--------");
        System.out.println(boy.getState());
        boy.restoreMemento(caretaker.getMemento());
        System.out.println("--------男孩恢复后状态-----");
        System.out.println(boy.getState());
    }
}
