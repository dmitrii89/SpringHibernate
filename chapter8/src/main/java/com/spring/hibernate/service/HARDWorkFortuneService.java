package com.spring.hibernate.service;

import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii on 07.01.2019.
 */
@Component
public class HARDWorkFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Work hard and you will get fortune!";
    }
}
