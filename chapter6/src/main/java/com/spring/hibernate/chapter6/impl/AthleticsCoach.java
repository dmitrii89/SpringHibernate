package com.spring.hibernate.chapter6.impl;

import com.spring.hibernate.chapter6.Coach;
import com.spring.hibernate.chapter6.FortuneService;

/**
 * Created by Dmitrii on 10.01.2019.
 */
public class AthleticsCoach {
    private String name;

    public AthleticsCoach( String name) {
        System.out.println("New Athletics coach #" + name);
        this.name = name;
    }

    public void initMethodYoYo() {
        System.out.println("Athletics coach #" + name + " init method");
    }

    public void destroyMethodHaHa() {
        System.out.println("Athletics coach #" + name + " destroy method");
    }
}
