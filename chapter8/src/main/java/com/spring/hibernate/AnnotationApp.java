package com.spring.hibernate;

import com.spring.hibernate.coach.BoxingCoach;
import com.spring.hibernate.coach.FootballCoach;
import com.spring.hibernate.coach.SwimCoach;
import com.spring.hibernate.coach.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
        //Practice right hand kick
        //You will have a lucky day

        BoxingCoach boxingCoach = context.getBean("boxingCoach", BoxingCoach.class);
        System.out.println(boxingCoach.getDailyWorkout());
        System.out.println(boxingCoach.getDailyFortune());
        //Sparring in the morning and in the evening
        //You will have a lucky day

        FootballCoach footballCoach = context.getBean("footballCoach", FootballCoach.class);
        System.out.println(footballCoach.getDailyWorkout());
        System.out.println(footballCoach.getDailyFortune());
        //Kick a ball as hard as you can
        //Master only one thing

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println(swimCoach.getGames());
        //Swim 2km daily
        //Work hard and you will get fortune!
        //Olympics 2018
    }
}
