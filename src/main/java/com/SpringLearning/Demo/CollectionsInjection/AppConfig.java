package com.SpringLearning.Demo.CollectionsInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.SpringLearning.Demo.CollectionsInjection")
public class AppConfig {

    @Bean
    public EmployeeFactory employeeFactory() {
        return new EmployeeFactory();
    }
}
