package com.SpringLearning.Demo.AutoWiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Autowiring.xml");
        Human human = context.getBean("human", Human.class);
        human.startPumping();
    }
}
