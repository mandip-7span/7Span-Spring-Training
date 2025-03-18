package com.SpringLearning.Demo.ConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CITest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user3", User.class);
        User user4 = context.getBean("user4", User.class);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
    }
}
