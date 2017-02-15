package com.github.siemen.model;

/**
 * Created by Zhan on 2017/2/15 0015.
 */
public class Greeting {
    private long id;
    private String context;

    public Greeting(long id, String context) {
        this.id = id;
        this.context = context;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
