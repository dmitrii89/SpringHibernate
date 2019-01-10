package com.spring.hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TennisCoach sillyCoach = context.getBean("thatSillyCoach", TennisCoach.class);
        System.out.println(sillyCoach.getDailyWorkout());
        //Practice right hand kick

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(swimCoach.getDailyWorkout());
        //Swim 2 km daily
    }
}
