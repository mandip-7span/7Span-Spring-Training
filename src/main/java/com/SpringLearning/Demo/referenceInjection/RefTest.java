package com.SpringLearning.Demo.referenceInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class RefTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students do you want to enter? ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= studentCount; i++) {
            Student student = context.getBean(Student.class);
            Address address = context.getBean(Address.class);

            System.out.println("\nEnter details for Student " + i + ":");

            System.out.print("ID: ");
            student.setId(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Name: ");
            student.setName(scanner.nextLine());

            System.out.print("City: ");
            address.setCity(scanner.nextLine());

            System.out.print("State: ");
            address.setState(scanner.nextLine());

            System.out.print("Country: ");
            address.setCountry(scanner.nextLine());

            student.setAddress(address);

            System.out.println("\nStudent Details Saved:");
            System.out.println(student);
        }

        scanner.close();
    }
}
