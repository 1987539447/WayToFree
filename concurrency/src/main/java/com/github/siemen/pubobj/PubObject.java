package com.github.siemen.pubobj;
/**
 * Created by Zhan on 2017-06-19.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * 发布对象
 * 通过静态域或者公共方法发布对象
 * states逸出，调用者可修改数组内容
 */
public class PubObject {
    public static Set<String> knownSecret;
    private String[] states = {"AK","AL","AB"};

    public void initialize(){
        knownSecret = new HashSet<String>();
    }

    public String[] getStates(){
        return this.states;
    }



    /**animals限制在本地栈中*/
    public int loadTheArk(Collection<Animal> candidates){
        SortedSet animals;
        int numPairs = 0;
        Animal canditae = null;
        animals = new TreeSet<Animal>(new SpeciesGenerComparator());
        animals.add(candidates);
        //.....
        return numPairs;
    }


    /**ThreadLocal 保证线程封闭性*/
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
      public Connection initialValue(){
          try {
              return DriverManager.getConnection("");
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return  null;
      }
    };

    public static Connection getConnection(){
        return connectionHolder.get();
    }



    private class Animal {
    }

    private class SpeciesGenerComparator implements Comparator<Animal> {

        public int compare(Animal o1, Animal o2) {
            return 0;
        }
    }
}
