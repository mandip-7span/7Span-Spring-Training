package com.SpringLearning.Demo.referenceInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("referanceConfig.xml");
        Student student = (Student) context.getBean("Student_A");
        System.out.println(student.address);
        System.out.println(student);
    }
}
