package com.SpringLearning.Demo.ConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CITest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructor.xml");
        User user1 = (User) context.getBean("User1");
        User user2 = (User) context.getBean("User2");
        System.out.println(user1);
        System.out.println(user2);
    }
}
