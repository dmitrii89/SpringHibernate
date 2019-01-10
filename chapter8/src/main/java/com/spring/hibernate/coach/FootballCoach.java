package com.spring.hibernate.coach;

import com.spring.hibernate.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Autowired
    @Qualifier("randomFortunes")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Kick a ball as hard as you can";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
