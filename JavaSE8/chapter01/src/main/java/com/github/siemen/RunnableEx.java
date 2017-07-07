package com.github.siemen;

/**
 * Created by Zhan on 2017-07-06.
 */
@FunctionalInterface
public interface RunnableEx {

    void run() throws Exception;

    static Runnable uncheck(RunnableEx runner){
        return ()->{
            try {
            runner.run();
        }catch (Exception ex){
                System.out.println("----exception catched---");
            }
        };
    }
}
