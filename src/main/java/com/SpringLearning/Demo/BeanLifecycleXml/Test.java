package com.SpringLearning.Demo.BeanLifecycleXml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeanLifecycleUsingXml.xml");
        Student student1 = (Student) context.getBean("Student_1");
        System.out.println(student1);
        context.registerShutdownHook();
    }
}
