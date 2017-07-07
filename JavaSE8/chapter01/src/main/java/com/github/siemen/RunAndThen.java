package com.github.siemen;

/**
 * Created by Zhan on 2017-07-07.
 */
public interface RunAndThen {

    static Runnable andThen(Runnable first,Runnable then){
        return ()->{
            first.run();
            then.run();
        };
    }
}
