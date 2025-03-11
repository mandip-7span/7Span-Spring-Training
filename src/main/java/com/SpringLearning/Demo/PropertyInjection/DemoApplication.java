package com.SpringLearning.Demo.PropertyInjection;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many students do you want to enter? ");
		int studentCount = scanner.nextInt();
		scanner.nextLine(); // Consume the newline

		for (int i = 1; i <= studentCount; i++) {
			// Create a new Student object with prototype scope
			Student student = context.getBean(Student.class);

			System.out.println("\nEnter details for Student " + i + ":");

			System.out.print("ID: ");
			student.setId(scanner.nextInt());
			scanner.nextLine(); // Consume newline

			System.out.print("Name: ");
			student.setName(scanner.nextLine());

			System.out.print("Address: ");
			student.setAddress(scanner.nextLine());

			System.out.println("\nStudent Details Saved:");
			System.out.println(student);
		}

		scanner.close();
	}

}
