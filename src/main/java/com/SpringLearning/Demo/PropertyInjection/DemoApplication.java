package com.SpringLearning.Demo.PropertyInjection;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("hello");
//		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Student student1 = (Student) context.getBean("Student1");
		Student student2 = (Student) context.getBean("Student2");
		Student student3 = (Student) context.getBean("Student3");
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}

}
