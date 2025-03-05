package com.SpringLearning.Demo.ScopeOfBean.Prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(NotificationServiceConfig.class);
        NotificationService notificationService1 = context.getBean("notificationService", NotificationService.class);
        NotificationService notificationService2 = context.getBean("notificationService", NotificationService.class);

        //here both are given different hashcode bcz here every time make a new object
        System.out.println(notificationService1.hashCode());
        System.out.println(notificationService2.hashCode());
    }
}
