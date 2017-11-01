package com.github.siemen;
/**
 * Created by Zhan on 2017-10-18.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 自定义subject实例.
 * 系统启动-引导时
 * 集成测试
 * 后台进程
 */
public class CustomSubject {

    public static void main(String[] args) {
        //无参，SecurityUtils.getSubject()使用当前程序securityManager
        Subject subject = new Subject.Builder().buildSubject();

        //指定使用额外的securityManager
        SecurityManager securityManager = SecurityUtils.getSecurityManager();
        Subject subject1 = new Subject.Builder(securityManager).buildSubject();

        //创建一个确定身份的subject
        String userIdentity = "admin";
        String realmName = "myRealm";
        PrincipalCollection principalCollection = new SimplePrincipalCollection(userIdentity,realmName);
        Subject subject2 = new Subject.Builder().principals(principalCollection).buildSubject();

        /**********以上仅创建subject 但未关联到线程***********/
        //关联线程 保证线程内执行时可SecurityUtils.getSubjects, 执行结束释放关联
        //自动关联 线程结束自动清除
        subject.execute(new Runnable() {
            @Override
            public void run() {
                //bound to current thread
            }
        });
        subject.execute(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        //手动关联
        SubjectThreadState threadState = new SubjectThreadState(subject);
        threadState.bind();
        try{
            //execute work as the build subject
        }finally {
            //ensure any state is cleaned
            threadState.clear();
        }

        // 绑定不同线程执行
        Callable<String> work = () -> null;
        work = subject.associateWith(work);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(work);

    }
}
