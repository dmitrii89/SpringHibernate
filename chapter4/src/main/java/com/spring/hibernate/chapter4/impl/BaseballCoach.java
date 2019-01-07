package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.AbstractCoach;
import com.spring.hibernate.chapter4.Coach;
import com.spring.hibernate.chapter4.FortuneService;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public class BaseballCoach  extends AbstractCoach {

    public BaseballCoach(FortuneService fortuneService) {
        super(fortuneService);
    }

    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
