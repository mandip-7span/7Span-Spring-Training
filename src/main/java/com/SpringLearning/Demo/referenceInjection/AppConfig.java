package com.SpringLearning.Demo.referenceInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.SpringLearning.Demo.referenceInjection")
public class AppConfig {

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Address address() {
        return new Address();
    }
}
