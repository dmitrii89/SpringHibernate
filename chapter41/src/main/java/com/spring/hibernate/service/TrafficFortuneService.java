package com.spring.hibernate.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitrii on 10.02.2019.
 */
@Component
public class TrafficFortuneService {

    public String getFortune() {
        sleep();
        return "Expect heavy traffic this morning";
    }

    public String getFortuneForLogger() {
        sleep();
        return "Expect heavy traffic this morning";
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
