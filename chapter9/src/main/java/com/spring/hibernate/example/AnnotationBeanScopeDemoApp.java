package com.spring.hibernate.example;

import com.spring.hibernate.example.coach.SwimCoach;
import com.spring.hibernate.example.coach.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TennisCoach tennisCoach1 = context.getBean("tennisCoach", TennisCoach.class);
        TennisCoach tennisCoach2 = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println("The same tennis coach object: " + (tennisCoach1 == tennisCoach2)); // true

        SwimCoach swimCoach1 = context.getBean("swimCoach", SwimCoach.class);
        SwimCoach swimCoach2 = context.getBean("swimCoach", SwimCoach.class);
        System.out.println("The same swim coach object: " + (swimCoach1 == swimCoach2)); // false

        context.close();
    }
}
