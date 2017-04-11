package com.github.siemen.zenofdesignpattern.composite;
/**
 * Created by Zhan on 2017-04-06.
 */

import java.util.List;

/**
 * 组装调用
 */
public class Client {
    public static void main(String[] args) {

        Branch ceo = compositeCorpTree();
        System.out.println(ceo.getInfo());
        System.out.println(getTreeInfo(ceo));

    }

    private static Branch compositeCorpTree() {
        Branch root = new Branch("牛云","总经理",123141241);
        Branch devManager = new Branch("老牛","项目经理",12314);
        Leaf liu = new Leaf("小刘","研发",1231);
        Leaf wang = new Leaf("小王","研发",1235);
        Leaf mei = new Leaf("小美","秘书",12341);
        root.addSubordinate(devManager);
        root.addSubordinate(mei);
        devManager.addSubordinate(liu);
        devManager.addSubordinate(wang);
        return root;
    }

    public static String getTreeInfo(Branch root){
        List<Corp> subordinateList = root.getSubordinate();
        StringBuilder info = new StringBuilder();
        for (Corp corp : subordinateList) {
            if(corp instanceof Leaf){
                info.append(corp.getInfo()).append("\n");
            }else{
                info.append(corp.getInfo()).append("\n").append(getTreeInfo((Branch) corp));
            }
        }
        return info.toString();
    }
}
