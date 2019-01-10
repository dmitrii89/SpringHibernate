package com.spring.hibernate.service;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You will have a lucky day";
    }
}
