package com.github.siemen.zenofdesignpattern.shell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhan on 2017-04-17.
 */
public enum CommandEnum {
    ls("com.github.siemen.zenofdesignpattern.shell.LSCommand");

    private final String value;

    CommandEnum(String value) {
        this.value = value;
    }

    public static List<String> getNames(){
        List<String> nameList = new ArrayList<>();
        CommandEnum[] commandEna = CommandEnum.values();
        for (CommandEnum commandEnum : commandEna) {
            nameList.add(commandEnum.name());
        }
        return nameList;
    }

    public String getValue() {
        return this.value;
    }
}
