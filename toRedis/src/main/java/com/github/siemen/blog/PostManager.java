package com.github.siemen.blog;
/**
 * Created by Zhan on 2017-06-09.
 */

import java.util.Scanner;

/**
 * 文章发布管理
 */
public class PostManager {

    private static final Scanner CONSOLE = new Scanner(System.in);
    private static final PostServer POST_SERVER = new PostServer();


    public static void main(String[] args) {

        while (true){
            showMenu();
            System.out.println("---------------请选择：");
            String action = CONSOLE.nextLine().toUpperCase();
            switch (action){
                case "A":
                    setAdmin();
                    break;
                case "B":
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    System.out.println("不支持的功能~~");
            }
        }
    }

    private static void quit() {
        System.out.println("再见~~~");
        System.exit(0);
    }

    private static void showMenu() {
        String admin = POST_SERVER.getAdmin();
        if(admin == null || "".equals(admin)){
            admin = setAdmin();
        }
        System.out.println("欢迎"+admin+"~~~");
        printMenu();
    }

    private static void printMenu() {
        System.out.println("--------------------------菜单------------------------------");
        System.out.println("A:修改管理用户    B:查看文章列表");
        System.out.println("Q:退出");
    }

    private static String setAdmin() {
        System.out.println("请输入管理用户名~~");
        String admin = CONSOLE.nextLine();
        POST_SERVER.setAdmin(admin);
        return admin;
    }

}
