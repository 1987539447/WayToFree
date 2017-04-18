package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

/**
 * 文件处理类-模拟命令执行
 */
public class FileManager {

    public static String ls(String data){
        return  "apache-activemq-5.14.4  apache-ignite-fabric-1.9.0-bin  apache-tomcat-8.5.13  install  jdk1.8.0_121  jkzsfiles  tmlog6.log  upload";
    }

    public static String ls_a(String data){
        return ".   apache-activemq-5.14.4          apache-tomcat-8.5.13  .bash_logout   .bashrc  jdk1.8.0_121  .mysql_history     tmlog6.log  .viminfo\n" +
                "..  apache-ignite-fabric-1.9.0-bin  .bash_history         .bash_profile  install  jkzsfiles     .oracle_jre_usage  upload";
    }

    public static String ls_l(String data){
        return "total 64\n" +
                "drwxr-xr-x 11 jkzs jkzs  4096 Apr 12 18:16 apache-activemq-5.14.4\n" +
                "drwxr-xr-x 10 jkzs jkzs  4096 Apr 12 17:10 apache-ignite-fabric-1.9.0-bin\n" +
                "drwxrwxr-x  9 jkzs jkzs  4096 Apr 12 16:48 apache-tomcat-8.5.13\n" +
                "drwxrwxr-x  2 jkzs jkzs  4096 Apr 13 10:29 install\n" +
                "drwxr-xr-x  8 jkzs jkzs  4096 Dec 13 08:50 jdk1.8.0_121\n" +
                "drwxrwxr-x  4 jkzs jkzs  4096 Apr 14 17:49 jkzsfiles\n" +
                "-rw-r-----  1 jkzs jkzs 36630 Apr 14 10:39 tmlog6.log\n" +
                "drwxrwxr-x  2 jkzs jkzs  4096 Apr 14 09:58 upload";
    }
}
