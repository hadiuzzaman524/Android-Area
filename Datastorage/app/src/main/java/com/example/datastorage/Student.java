package com.example.datastorage;

public class Student {

    String name;
    String age;
    String mobile;

    public Student(String name, String age, String mobile) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }
}
