package com.SpringLearning.Demo.LooseCoupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("LooseCoupling.xml");
        Student student = context.getBean("student1", Student.class);
        student.cheating();
    }
}
