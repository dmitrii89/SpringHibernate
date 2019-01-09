package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.Coach;
import com.spring.hibernate.chapter4.FortuneService;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;


    public CricketCoach() {
        System.out.println("Inside Cricket Coach constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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
