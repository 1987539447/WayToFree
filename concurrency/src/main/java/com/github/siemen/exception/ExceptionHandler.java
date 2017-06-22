package com.github.siemen.exception;
/**
 * Created by Zhan on 2017-06-22.
 */

/**
 * 处理线程运行抛出的异常
 */
public class ExceptionHandler {
    public static RuntimeException launderThrowable(Throwable throwable){
        if(throwable instanceof RuntimeException){
            return (RuntimeException) throwable;
        }else if(throwable instanceof Error){
            throw (Error) throwable;
        }else {
            throw new IllegalStateException("not checked",throwable);
        }
    }
}
