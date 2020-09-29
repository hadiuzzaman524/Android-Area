package com.example.databaseex;

public class StudentInfo {

    String name;
    String phone;
    String age;

    public StudentInfo() {
    }

    public StudentInfo(String name, String phone, String age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }
}
