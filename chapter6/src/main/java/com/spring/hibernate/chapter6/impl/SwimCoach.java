package com.spring.hibernate.chapter6.impl;

import com.spring.hibernate.chapter6.Coach;
import com.spring.hibernate.chapter6.FortuneService;

/**
 * Created by Dmitrii on 10.01.2019.
 */
public class SwimCoach implements Coach {
    protected FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("New Swim Coach");
    }

    public String getDailyWorkout() {
        return "Swim 2 kilometers daily";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
