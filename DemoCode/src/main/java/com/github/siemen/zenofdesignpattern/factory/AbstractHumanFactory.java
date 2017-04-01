package com.github.siemen.zenofdesignpattern.factory;
/**
 * Created by Zhan on 2017-03-29.
 */

/**
 * 创建人类抽象工厂
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> Human createHuman(Class<T> clazz);
}
