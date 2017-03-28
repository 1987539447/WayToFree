package com.github.siemen.effective.singleton;

/**
 * Created by Zhan on 2017/3/22 0022.
 */
public class SingletonTest {

    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        DataSource instacne = DataSource.INSTACNE;
        System.out.println(elvis.getDes());
        System.out.println(instacne.getDes());
    }
}
