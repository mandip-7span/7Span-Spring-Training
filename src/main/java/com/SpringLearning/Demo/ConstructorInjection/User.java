package com.SpringLearning.Demo.ConstructorInjection;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private String password;

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
