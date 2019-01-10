package com.spring.hibernate.coach;

import com.spring.hibernate.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    //@Autowired
    public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice right hand kick";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
