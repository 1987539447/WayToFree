package com.github.siemen.zenofdesignpattern.memento;
/**
 * Created by Zhan on 2017-04-07.
 */


/**
 * 备忘录管理类
 */
public class Caretaker {


    private IMemento memento;

    public IMemento getMemento(){
        return  this.memento;
    }
    void setMemento(IMemento memento){
        this.memento = memento;
    }
}
