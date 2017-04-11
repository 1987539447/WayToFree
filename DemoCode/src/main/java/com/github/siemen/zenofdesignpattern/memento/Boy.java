package com.github.siemen.zenofdesignpattern.memento;
/**
 * Created by Zhan on 2017-04-07.
 */

/**
 * 男孩类-原始对象类
 */
public class Boy {
    private String state;

    public void changeState(){
        this.state = "可能心情不太好！";
    }

    public String getState(){
        return  this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public IMemento createMemento(){
        return  new Memento(this.state);
    }

    public void restoreMemento(IMemento memento){
        this.setState(((Memento)memento).getState());
    }


    private class Memento implements IMemento{

        private String state;
        public Memento(String state) {
            this.state = state;
        }

        public String getState(){
            return  this.state;
        }
    }

}
