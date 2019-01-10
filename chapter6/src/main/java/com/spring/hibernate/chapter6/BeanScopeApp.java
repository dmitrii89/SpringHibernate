package com.spring.hibernate.chapter6;

import com.spring.hibernate.chapter6.impl.SwimCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach singletonCoach1 = ctx.getBean("singletonCoach", SwimCoach.class);
        Coach singletonCoach2 = ctx.getBean("singletonCoach", SwimCoach.class);
        System.out.println("The same object: " + (singletonCoach1 == singletonCoach2)); // true

        Coach prototypeCoach1 = ctx.getBean("prototypeCoach", SwimCoach.class);
        Coach prototypeCoach2 = ctx.getBean("prototypeCoach", SwimCoach.class);
        System.out.println("The same object: " + (prototypeCoach1 == prototypeCoach2)); // false

//        New Swim Coach
//        The same object: true
//        New Swim Coach
//        New Swim Coach
//        The same object: false

        ctx.close();
    }
}
