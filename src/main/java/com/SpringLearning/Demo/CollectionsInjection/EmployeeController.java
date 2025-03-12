package com.SpringLearning.Demo.CollectionsInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeFactory employeeFactory;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeFactory.createEmployee(employee.getName(), employee.getAddress(), employee.getPhones(), employee.getCourse());
    }
}
