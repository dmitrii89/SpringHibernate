package com.spring.hibernate.example.coach;

import com.spring.hibernate.example.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice right hand kick";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
