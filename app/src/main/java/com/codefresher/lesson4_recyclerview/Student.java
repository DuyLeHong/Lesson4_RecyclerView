package com.codefresher.lesson4_recyclerview;

public class Student {

    private String sName;
    private int age;

    public Student(String sName, int age) {
        this.sName = sName;
        this.age = age;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
