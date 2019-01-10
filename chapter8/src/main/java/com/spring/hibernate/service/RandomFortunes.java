package com.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class RandomFortunes implements FortuneService {

    private Random random = new Random();
    private String[] fortunesArray;

    @Value("${sport.fortunes}")
    String fortunes;

    @PostConstruct
    public void setupMyData() {
        fortunesArray = fortunes.split(",");
    }

    @Override
    public String getFortune() {
        return fortunesArray[random.nextInt(3)];
    }
}

