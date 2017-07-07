package com.github.siemen;
/**
 * Created by Zhan on 2017-07-07.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 扩展Collection接口，增加默认方法
 */
public interface MyCollection<E> extends Collection<E> {
    default void forEachIf(Consumer<E> action, Predicate<E> filter){
        Collection<E> view = new ArrayList<>();
        forEach(e -> {
            if (filter.test(e)) {
                view.add(e);
            }
            });
        view.forEach(action);
    }
}
