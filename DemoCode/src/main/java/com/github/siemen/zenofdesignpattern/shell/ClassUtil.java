package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * class工具类
 */
public class ClassUtil {

    public static List<Class> getSonClass(Class clazz){
        List<Class> sonClass = new ArrayList<>();
        String packageName = clazz.getPackage().getName();
        List<Class> pkgClass = getClasses(packageName);
        for (Class pkgClas : pkgClass) {
            if(clazz.isAssignableFrom(pkgClas) && !clazz.equals(pkgClas)){
                sonClass.add(pkgClas);
            }
        }
        return sonClass;
    }

    private static List<Class> getClasses(String packageName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.','/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<>();
        for (File dir : dirs) {
            classes.addAll(findClasses(dir,packageName));
        }


        return classes;
    }

    private static List<Class> findClasses(File dir, String packageName) {
        List<Class> classes = new ArrayList<>();
        if(!dir.exists()){
            return classes;
        }
        File[] filese = dir.listFiles();
        for (File file : filese) {
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file,packageName+"."+file));
            }else if(file.getName().endsWith(".class")){
                try {
                    classes.add(Class.forName(packageName+"."+file.getName().substring(0, (file.getName().length()-6))));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }
}
