package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 人类创建工厂
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> Human createHuman(Class<T> clazz) {
        Human human = null;
        try {
            human = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return human;
    }
}
