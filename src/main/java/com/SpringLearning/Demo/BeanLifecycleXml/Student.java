package com.SpringLearning.Demo.BeanLifecycleXml;

public class Student {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set name of student");
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void init() {
        System.out.println("inside init method");
    }

    public void destroy() {
        System.out.println("inside destroy method");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
