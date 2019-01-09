package com.spring.hibernate.chapter4.impl;

import com.spring.hibernate.chapter4.FortuneService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFortune implements FortuneService {
    private List<String> fortunes = Arrays.asList(
            "Be careful - it will give you success",
            "Master only one thing",
            "Genius is only 15% genetics, but 85% of hard work"
    );

    @Override
    public String getFortune() {
        return fortunes.get(new Random().nextInt(3));
    }
}
