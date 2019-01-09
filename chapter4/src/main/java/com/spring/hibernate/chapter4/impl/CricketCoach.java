package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.Coach;
import com.spring.hibernate.chapter4.FortuneService;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("Inside Cricket Coach constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice cricket 45 minutes 2 times a day";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
