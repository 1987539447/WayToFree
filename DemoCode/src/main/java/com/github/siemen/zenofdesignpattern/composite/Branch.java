package com.github.siemen.zenofdesignpattern.composite;
/**
 * Created by Zhan on 2017-04-06.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝职工
 */
public class Branch extends Corp {

    private List<Corp> subordinateList = new ArrayList<>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    public void addSubordinate(Corp corp){
        this.subordinateList.add(corp);
    }

    public  List<Corp> getSubordinate(){
        return this.subordinateList;
    }
}
