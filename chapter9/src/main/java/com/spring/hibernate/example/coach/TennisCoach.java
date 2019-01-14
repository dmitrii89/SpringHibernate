package com.spring.hibernate.example.coach;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton") // may be removed, singleton is by default
public class TennisCoach implements Coach {

    public TennisCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Practice right hand kick";
    }

    @Override
    public String getDailyFortune() {
        return "Simple be best";
    }

    @PostConstruct
    private void postConstructMethod() {
        System.out.println(">> Post construct method body");
    }

    @PreDestroy
    private void preDestroyMethod() {
        System.out.println(">> Pre destroy method body");
    }
}
