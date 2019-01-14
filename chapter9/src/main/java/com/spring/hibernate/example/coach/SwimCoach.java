package com.spring.hibernate.example.coach;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SwimCoach implements Coach {

    public SwimCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 2 km daily";
    }

    @Override
    public String getDailyFortune() {
        return "Simple be best";
    }
}
