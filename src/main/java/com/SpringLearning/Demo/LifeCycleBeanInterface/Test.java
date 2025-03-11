package com.SpringLearning.Demo.LifeCycleBeanInterface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner scanner = new Scanner(System.in);
        Student student = context.getBean(Student.class);

        System.out.println("\nEnter details for Student " + ":");

        System.out.print("Name: ");
        student.setName(scanner.nextLine());

        System.out.print("ID: ");
        student.setId(scanner.nextInt());

        System.out.println(student);
        context.registerShutdownHook();
    }
}
