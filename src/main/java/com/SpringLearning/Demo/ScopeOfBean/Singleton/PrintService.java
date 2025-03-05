package com.SpringLearning.Demo.ScopeOfBean.Singleton;

import org.springframework.stereotype.Component;

@Component
public class PrintService {

    public void print(String message) {
        System.out.println("Printing : " + message);
    }
}
