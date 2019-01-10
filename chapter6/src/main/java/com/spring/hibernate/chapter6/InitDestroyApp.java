package com.spring.hibernate.chapter6;

import com.spring.hibernate.chapter6.impl.AthleticsCoach;
import com.spring.hibernate.chapter6.impl.SwimCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanInitDestroy-applicationContext.xml");

        AthleticsCoach singletonCoach1 = ctx.getBean("athleticsCoachSingleton", AthleticsCoach.class);
        AthleticsCoach singletonCoach2 = ctx.getBean("athleticsCoachSingleton", AthleticsCoach.class);

        AthleticsCoach prototypeCoach1 = ctx.getBean("athleticsCoachPrototype", AthleticsCoach.class);
        AthleticsCoach prototypeCoach2 = ctx.getBean("athleticsCoachPrototype", AthleticsCoach.class);

        ctx.close();

//        New Athletics coach #1
//        Athletics coach #1 init method
//        New Athletics coach #2
//        Athletics coach #2 init method
//        New Athletics coach #2
//        Athletics coach #2 init method
//        Athletics coach #1 destroy method
    }
}
