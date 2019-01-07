package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.Coach;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Swim 7 kilometers daily";
    }
}
