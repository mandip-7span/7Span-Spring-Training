package com.SpringLearning.Demo.LifeCycleBeanInterface;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initialize the bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy the bean");
    }
}
