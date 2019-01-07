package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.Coach;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public class BaseballCoach implements Coach {

    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
