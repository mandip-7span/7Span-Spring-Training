package com.SpringLearning.Demo.AutoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Human {

    @Autowired
    @Qualifier("humanheart") //-you can also use annotation here it is work properly and
//    if use autoeire before dependancy like this than not need to setter because it is not run setter method
    private Heart heart;

    public Human() {
    }

    //@Autowired - it is used for injecting heart object without use autowire property explicitely
    public Human(Heart heart) {
        this.heart = heart;
    }

    //@Autowired - you can also use autowired here
    // here first check byType if fail than check byName if it is also fail than it will show error
    //@Qualifier("humanheart")- when both case are fail than it is used find the object by name
    // which is passing in it
    public void setHeart(Heart heart) {
        this.heart = heart;
    }

    public void startPumping() {
        if (heart != null) {
            heart.pump();
            System.out.println("name of animal is : " + heart.getNameOfAnimal() + " " + "no. of heart is : " + heart.getNoOfHeart());
        } else {
            System.out.println("you are dead");
        }
    }
}
