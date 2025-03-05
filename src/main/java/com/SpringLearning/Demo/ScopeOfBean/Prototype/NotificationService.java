package com.SpringLearning.Demo.ScopeOfBean.Prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // here declare scope of bean as prototype
public class NotificationService {

    public void notified(String message) {
        System.out.println("Notification : " + message);
    }
}
