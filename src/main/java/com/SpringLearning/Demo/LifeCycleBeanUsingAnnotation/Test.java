package com.SpringLearning.Demo.LifeCycleBeanUsingAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Subject subject = context.getBean(Subject.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter subject name : ");
        subject.setName(sc.nextLine());
        System.out.println();
        System.out.println(subject);
        context.registerShutdownHook();
    }
}
