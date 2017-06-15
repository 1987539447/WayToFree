package com.github.siemen.juc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Zhan on 2017-05-26.
 * 对象保护锁
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface GuardedBy {
    String value();
}
