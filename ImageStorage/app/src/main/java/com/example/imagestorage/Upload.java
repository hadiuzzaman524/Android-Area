package com.example.imagestorage;

public class Upload {

    String name;
    String age;
    String uri;

    public Upload() {
    }

    public Upload(String name, String age, String uri) {
        this.name = name;
        this.age = age;
        this.uri = uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getUri() {
        return uri;
    }



}
