package com.SpringLearning.Demo.AutoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Human human = context.getBean(Human.class);
        human.startPumping();
    }
}
