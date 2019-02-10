package com.spring.hibernate.app;

import com.spring.hibernate.DemoConfig;
import com.spring.hibernate.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * Created by Dmitrii on 07.02.2019.
 */
public class AroundWithLoggerExceptionApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerExceptionApp.class.getName());

    public static void main(String[] args) {

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("Main program: AroundApp");
        myLogger.info("------");

        try {
            String fortune = service.getFortuneOrNot(true);
            myLogger.info("My fortune: " + fortune);
        } catch (Exception e) {
            myLogger.info(e.toString());
        }
        myLogger.info("Finished");
        context.close();
    }

    //фев 10, 2019 10:51:28 PM com.spring.hibernate.app.AroundWithLoggerExceptionApp main
    //INFO: Main program: AroundApp
    //фев 10, 2019 10:51:28 PM com.spring.hibernate.app.AroundWithLoggerExceptionApp main
    //INFO: ------
    //фев 10, 2019 10:51:28 PM com.spring.hibernate.aspect.LoggingAspectOrNot aroundGetFortuneLogger
    //INFO: ======>>> Executing @Around on method: TrafficFortuneService.getFortuneOrNot(..)
    //фев 10, 2019 10:51:29 PM com.spring.hibernate.aspect.LoggingAspectOrNot aroundGetFortuneLogger
    //WARNING: ======>>> Alarm!!! Something went wrong!
    //фев 10, 2019 10:51:29 PM com.spring.hibernate.app.AroundWithLoggerExceptionApp main
    //INFO: java.lang.RuntimeException: Highway is closed!!!
    //фев 10, 2019 10:51:29 PM com.spring.hibernate.app.AroundWithLoggerExceptionApp main
    //INFO: Finished

}
