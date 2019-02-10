package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.dao.AccountDAO;
import com.spring.hibernate.model.Account;
import com.spring.hibernate.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class AroundApp {

    public static void main(String[] args) {

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main program: AroundApp");
        System.out.println("------");

        String fortune = service.getFortune();
        System.out.println("My fortune: " + fortune);

        System.out.println("Finished");
        context.close();
    }

    //

}
