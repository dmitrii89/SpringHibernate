package com.spring.hibernate.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secondLevel")
public class SecondLevelController {

    @RequestMapping(value = "/")
    public static String main() {
        return "student-form";
    }

    @RequestMapping(value = "/studentForm")
    public static String additional() {
        return "student-form";
    }
}
