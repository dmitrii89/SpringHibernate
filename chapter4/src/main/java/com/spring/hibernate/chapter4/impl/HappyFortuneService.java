package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.FortuneService;

/**
 * Created by Dmitrii on 07.01.2019.
 */
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
