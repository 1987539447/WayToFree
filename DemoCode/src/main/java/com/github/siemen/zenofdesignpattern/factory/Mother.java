package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 创人客户类
 */
public class Mother {
    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory();
        Human human;
        human = factory.createHuman(YellowHuman.class);
        human.getColor();
        human.talk();
        human = factory.createHuman(WhiteHuman.class);
        human.getColor();
        human.talk();
        human = factory.createHuman(BlackHuman.class);
        human.getColor();
        human.talk();
        human = SimpleHumanFactory.createHuman(YellowHuman.class);
        human.getColor();
        human.talk();
    }
}
