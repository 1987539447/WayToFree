package com.github.siemen;
/**
 * Created by Zhan on 2017-07-06.
 */

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static com.github.siemen.RunnableEx.uncheck;

/**
 *
 */
public class LambdaTest {
    public static void main(String[] args) throws Exception {
        //listSubDir();
        //listFiles();
        //orderFiles();
        //runAndThen();
        //catchVar();
        filterAndRun();
    }

    /**
     *
     * 查找指定目录下子目录
     * */
    private static void listSubDir() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("---input the root directory:");
        String root = scanner.nextLine();
        File rootDir = new File(root);
        File[] fileList;
        if(rootDir.isDirectory()){
            FileFilter filter = file->file.isDirectory();
            fileList = rootDir.listFiles(file->file.isDirectory());
            Arrays.stream(fileList).forEach(System.out::println);
        }else{
            System.out.println(root+" is not a directory");
        }
    }

    /**
     * 查找指定类型文件
     * */
    private static void listFiles(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("---input the root directory:");
        String root = scanner.nextLine();
        System.out.print("---input the extension,such like: .txt :");
        String ext = scanner.nextLine();
        File rootDir = new File(root);
        File[] fileList;
        if(rootDir.isDirectory()){
            fileList = rootDir.listFiles(file->file.getName().endsWith(ext));
            Arrays.stream(fileList).forEach(System.out::println);
        }else{
            System.out.println(root+" is not a directory");
        }
    }

    /**
     * 按指定顺序排序目录
     * */
    private static void orderFiles(){
        File[] files = new File("d:/").listFiles();
        Arrays.stream(files).sorted((fileA,fileB)->fileA.getName().compareTo(fileB.getName())).forEach(System.out::println);
    }

    /**
     * 构建捕获异常的函数接口
     * */
    private static void catchEx(){
        new Thread(uncheck(() -> {
            System.out.println("Zzzzzz~~~~");Thread.sleep(100);
        })).start();
    }

    /**
     * 静态方法合并执行两个Runnable任务
     * */
    private static void runAndThen(){
        Runnable task = RunAndThen.andThen(() -> System.out.println("first"), ()-> System.out.println("then"));
        new Thread(task).start();
    }

    /**
     * 测试变量捕获
     * 捕获的变量必须为实际上不可变的
     * */
    private static void catchVar() throws InterruptedException {
        String[] names = {"Peter","Paul","Marry"};

        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(()-> System.out.println(name));
        }
        System.out.println("----------with for in-----------");
        runners.forEach((runnable -> new Thread(runnable).start()));
        Thread.sleep(2000);
        runners.clear();
        System.out.println("-----------with for i----------");
/*        for (int i = 0; i < names.length; i++) {
            runners.add(()-> System.out.println(names[i]));//error: i cannot changged,var must actully final
        }*/
/*        for (AtomicInteger i = new AtomicInteger(); i.get() < names.length;) {//i没有自增，死循环了 ？？？
            runners.add(()-> System.out.println(names[i.getAndIncrement()]));
        }*/
        int[] index ={0};
        for (; index[0] < names.length;index[0]++) {//
            runners.add(()-> System.out.println(names[index[0]]));
        }
        runners.forEach((runnable -> new Thread(runnable).start()));
    }

    /**
     * 给接口增加默认方法，实现过滤执行
     * */
    private static void filterAndRun(){
        MyList<String> myList = new MyList<>();
        myList.add("Jack");
        myList.add("Rose");
        myList.add("Tom");
        myList.forEachIf(System.out::println, s -> s.compareTo("L")>0);
    }
}
