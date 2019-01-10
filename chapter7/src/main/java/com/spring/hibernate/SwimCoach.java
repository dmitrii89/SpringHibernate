package com.spring.hibernate;

import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim 2 km daily";
    }
}
