package com.SpringLearning.Demo.CollectionsInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeFactory employeeFactory = context.getBean(EmployeeFactory.class);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        List<String> phones = collectList(scanner, "phone number");
        Set<String> addresses = collectSet(scanner, "address");
        Map<String, String> courses = collectMap(scanner, "course name", "course description");

        Employee employee = employeeFactory.createEmployee(name, addresses, phones, courses);

        System.out.println("\nEmployee Details:");
        System.out.println(employee);

        scanner.close();
    }

    private static List<String> collectList(Scanner scanner, String itemName) {
        System.out.print("Enter number of " + itemName + "s: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        List<String> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter " + itemName + ": ");
            items.add(scanner.nextLine());
        }
        return items;
    }

    private static Set<String> collectSet(Scanner scanner, String itemName) {
        List<String> list = collectList(scanner, itemName);
        return new HashSet<>(list);
    }

    private static Map<String, String> collectMap(Scanner scanner, String keyName, String valueName) {
        System.out.print("Enter number of " + keyName + "s: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter " + keyName + ": ");
            String key = scanner.nextLine();
            System.out.print("Enter " + valueName + ": ");
            String value = scanner.nextLine();
            map.put(key, value);
        }
        return map;
    }
}
