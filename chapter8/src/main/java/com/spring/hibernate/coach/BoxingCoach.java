package com.spring.hibernate.coach;

import com.spring.hibernate.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach {
    private FortuneService fortuneService;

    @Autowired
    @Qualifier("happyFortuneService")
    public void doBoxingSetterInjection(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Sparring in the morning and in the evening";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
