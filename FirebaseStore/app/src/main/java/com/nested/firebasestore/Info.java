package com.nested.firebasestore;

public class Info {

    private String name;
    private String path;

    public Info(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Info() {
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
