package com.spring.hibernate.coach;

import com.spring.hibernate.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
    private FortuneService fortuneService;

    @Value("${games}")
    String games;

    @Autowired
    @Qualifier("HARDWorkFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 2km daily";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getGames() {
        return games;
    }
}
