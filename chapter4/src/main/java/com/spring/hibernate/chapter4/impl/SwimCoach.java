package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.AbstractCoach;
import com.spring.hibernate.chapter4.Coach;
import com.spring.hibernate.chapter4.FortuneService;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public class SwimCoach extends AbstractCoach {
    public SwimCoach(FortuneService fortuneService) {
        super(fortuneService);
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 2 kilometers daily";
    }
}
