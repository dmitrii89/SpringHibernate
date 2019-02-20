package com.spring.hibernate.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by Dmitrii on 19.02.2019.
 */
@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server: " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day";
    }


}
