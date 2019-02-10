package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class AroundWithLoggerApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerApp.class.getName());

    public static void main(String[] args) {

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("Main program: AroundApp");
        myLogger.info("------");

        String fortune = service.getFortuneForLogger();
        myLogger.info("My fortune: " + fortune);

        myLogger.info("Finished");
        context.close();
    }

    //фев 10, 2019 10:24:26 PM com.spring.hibernate.app.AroundWithLoggerApp main
    //INFO: Main program: AroundApp
    //фев 10, 2019 10:24:26 PM com.spring.hibernate.app.AroundWithLoggerApp main
    //INFO: ------
    //фев 10, 2019 10:24:29 PM com.spring.hibernate.app.AroundWithLoggerApp main
    //INFO: My fortune: Expect heavy traffic this morning
    //фев 10, 2019 10:24:29 PM com.spring.hibernate.app.AroundWithLoggerApp main
    //INFO: Finished

}
