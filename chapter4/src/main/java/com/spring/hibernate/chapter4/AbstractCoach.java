package com.spring.hibernate.chapter4;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public abstract class AbstractCoach implements Coach {
    protected FortuneService fortuneService;

    public AbstractCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
