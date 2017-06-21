package com.github.siemen.annotation;

/**
 * Created by Zhan on 2017-06-16.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Zhan on 2017-05-26.
 * 被指定锁保护
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface GuardedBy {
    String value();
}

