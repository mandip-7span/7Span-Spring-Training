package com.SpringLearning.Demo.CollectionsInjection;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class EmployeeFactory {
    public Employee createEmployee(String name, Set<String> addresses, List<String> phones, Map<String, String> courses) {
        return new Employee(name, addresses, phones, courses);
    }
}
