package com.SpringLearning.Demo.ScopeOfBean.Singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PrintServiceConfig.class);
        PrintService printService1 = context.getBean("printService", PrintService.class);
//        printService1.print("Print the my Adhar card");

        PrintService printService2 = context.getBean("printService", PrintService.class);

        //here both are same because one object is created(Singleton)
        System.out.println(printService1.hashCode());
        System.out.println(printService2.hashCode());
    }
}
