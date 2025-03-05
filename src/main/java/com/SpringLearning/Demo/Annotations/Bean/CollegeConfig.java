package com.SpringLearning.Demo.Annotations.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {

    @Bean(name = "colBean") // also you can give the bean name here than no need follow below sentance
    public College collegeBean() { // here must note that method name and your calling in test class name or id must be same
        College college = new College();
        return college;
    }
}
