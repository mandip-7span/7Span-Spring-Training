package com.SpringLearning.Demo.ConstructorInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User user1() {
        return new User("Alice", "mnbvcx");
    }

    @Bean
    public User user2() {
        return new User("Bob", "lkjhgf");
    }

    @Bean
    public User user3() {
        return new User("Charlie", "poiuyt");
    }

    @Bean
    public User user4() {
        return new User("Daisy", "adsfgh");
    }
}
