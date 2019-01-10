package com.spring.hibernate;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice right hand kick";
    }
}
