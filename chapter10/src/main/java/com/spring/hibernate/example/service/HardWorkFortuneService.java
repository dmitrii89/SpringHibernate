package com.spring.hibernate.example.service;

/**
 * Created by Dmitrii on 07.01.2019.
 */

public class HardWorkFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Work hard and you will get fortune!";
    }
}
