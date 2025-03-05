package com.SpringLearning.Demo.LifeCycleBeanUsingAnnotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycleUsingAnnotation.xml");
        Subject subject = (Subject) context.getBean("Subject1");
        System.out.println(subject);
        context.registerShutdownHook();
    }
}
