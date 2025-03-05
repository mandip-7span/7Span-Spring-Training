package com.SpringLearning.Demo.Annotations.Component;

import org.springframework.stereotype.Component;

@Component("CollegeBean")
class College {

    void print() {
        System.out.println("you are in a college");
    }
}
