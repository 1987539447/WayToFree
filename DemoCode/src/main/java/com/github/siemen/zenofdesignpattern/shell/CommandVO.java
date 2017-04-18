package com.github.siemen.zenofdesignpattern.shell;
/**
 * Created by Zhan on 2017-04-17.
 */

import java.util.*;

/**
 * 命令封装类-命令-选项-参数
 */
public class CommandVO {
    //命令分隔符
    public final static String DIVIDE_FLAG = " ";

    //命令前缀
    public final static String PREFIX = "-";

    //命令
    private String commandName = "";

    //参数列表
    private List<String> paramList = new ArrayList<>();
    //操作数列表
    private List<String> dataList = new ArrayList<>();

    //构建解析命令
    public CommandVO(String commandStr){
        if(commandStr != null && commandStr.length() !=0){
            String[] complexStr = commandStr.split(DIVIDE_FLAG);
            //命令
            this.commandName = complexStr[0];
            String temp;
            //参数 操作数
            for (int i = 1; i < complexStr.length; i++) {
                temp = complexStr[i];
                if(temp.indexOf(PREFIX) == 0){//选项
                    this.paramList.add(temp.replace(PREFIX,"").trim());
                }else{//操作数
                    this.dataList.add(temp);
                }
            }
        }else{
            System.out.println("命令解析失败，必须传入一个命令~");
        }
    }

    public String getCommandName(){
        return  this.commandName;
    }

    public List<String> getParam(){
        if(this.paramList.isEmpty()){
            this.paramList.add("");
        }
        return new ArrayList<>(new HashSet<>(this.paramList));

    }

    public List<String> getData(){
        return this.dataList;
    }

    public String formatData() {
        return null;
    }
}
