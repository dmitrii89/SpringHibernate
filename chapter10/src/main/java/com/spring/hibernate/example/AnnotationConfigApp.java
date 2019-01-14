package com.spring.hibernate.example;

import com.spring.hibernate.example.coach.SwimCoach;
import com.spring.hibernate.example.coach.TennisCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getDailyFortune());
        System.out.println(tennisCoach.getDailyWorkout());

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(swimCoach.getDailyFortune());
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getEmail());
        System.out.println(swimCoach.getTeam());

        context.close();

//        You will have a lucky day
//        Practice right hand kick
//        Work hard and you will get fortune!
//        Swim 2km daily
//        mail@mail.ru
//        Zenit Sankt-Peterburg
    }
}
