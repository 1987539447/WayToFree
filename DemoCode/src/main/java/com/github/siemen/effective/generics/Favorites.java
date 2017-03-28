package com.github.siemen.effective.generics;/**
 * Created by Zhan on 2017-03-28.
 */

import java.util.HashMap;
import java.util.Map;


/**
 * 最喜欢的类，类型安全异构容器
 */
public class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> clazz,T instance){
        if(clazz == null){
            throw new NullPointerException();
        }
        favorites.put(clazz,clazz.cast(instance));
    }

    public <T> T getFavorite(Class<T> clazz){
        return clazz.cast(favorites.get(clazz));
    }
}
