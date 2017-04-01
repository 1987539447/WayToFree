package com.github.siemen.zenofdesignpattern.abstractfactory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 创造者
 */
public class Creator {
    public static void main(String[] args) {
        Human human;
        MaleFactory maleFactory = new MaleFactory();
        human = maleFactory.createBlackHuman();
        human.getColor();
        human.talk();
        human.getSex();
        human = maleFactory.createWhiteHuman();
        human.getColor();
        human.talk();
        human.getSex();
        FemaleFactory femaleFactory = new FemaleFactory();
        human = femaleFactory.createBlackHuman();
        human.getColor();
        human.talk();
        human.getSex();
        human = femaleFactory.createWhiteHuman();
        human.getColor();
        human.talk();
        human.getSex();

    }
}
