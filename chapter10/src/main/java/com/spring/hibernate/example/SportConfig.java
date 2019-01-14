package com.spring.hibernate.example;

import com.spring.hibernate.example.coach.Coach;
import com.spring.hibernate.example.coach.SwimCoach;
import com.spring.hibernate.example.service.FortuneService;
import com.spring.hibernate.example.service.HappyFortuneService;
import com.spring.hibernate.example.service.HardWorkFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.spring.hibernate.example")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService hardWorkFortuneService() {
        return new HardWorkFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(hardWorkFortuneService());
    }

}
