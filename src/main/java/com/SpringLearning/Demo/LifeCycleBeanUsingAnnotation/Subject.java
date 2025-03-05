package com.SpringLearning.Demo.LifeCycleBeanUsingAnnotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Subject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void start() {
        System.out.println("method starting");
    }

    @PreDestroy
    public void end() {
        System.out.println("method ending");
    }
}
