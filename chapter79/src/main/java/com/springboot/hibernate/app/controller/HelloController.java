package com.springboot.hibernate.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * Created by Dmitrii on 22.02.2019.
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new Date());
        return "hello";
    }
}
