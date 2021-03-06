package com.spring.hibernate.chapter4;

import com.spring.hibernate.chapter4.impl.AthleticsCoach;
import com.spring.hibernate.chapter4.impl.BaseballCoach;
import com.spring.hibernate.chapter4.impl.HappyFortuneService;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public class NotSpringApp {
    public static void main(String[] args) {
        //Coach coach = new BaseballCoach();
        Coach coach = new AthleticsCoach(new HappyFortuneService());
        System.out.println(coach.getDailyWorkout());
    }
}
