package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 简单工厂
 */
public class SimpleHumanFactory {
    public static <T extends Human> Human createHuman(Class<T> clazz){
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
