package com.spring.hibernate.mvc.controllers;

import com.spring.hibernate.mvc.models.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("showForm")
    public String showFrom(Model theModel) {
        Person person = new Person();
        theModel.addAttribute("person", person);
        theModel.addAttribute("countryOptions", countryOptions);
        return "form";
    }

    @RequestMapping("processForm")
    public String processForm(@ModelAttribute("person") Person person) {
        System.out.println(person.getFirstName() + " " +  person.getLastName());
        return "confirmation";
    }
}
