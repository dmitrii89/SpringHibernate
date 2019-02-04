package com.spring.hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class SimpleController {

    @RequestMapping(value = "/listCustomers")
    public static String showForm() {
        return "list-customers";
    }
}
