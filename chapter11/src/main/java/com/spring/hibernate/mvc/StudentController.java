package com.spring.hibernate.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @RequestMapping(value = "/showForm")
    public static String showForm() {
        return "student-form";
    }

    @RequestMapping(value = "/processForm")
    public static String processForm() {
        return "confirmation";
    }

    @RequestMapping(value = "/uppercaseName")
    public String uppercaseName(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        String message = "Mr(s). " + studentName.toUpperCase();
        model.addAttribute("message", message);
        return "confirmation";
    }

    @RequestMapping(value = "/versionThree")
    public String versionThree(@RequestParam("studentName") String theName, Model model) {
        String message = "Mr(s). " + theName.toUpperCase();
        model.addAttribute("message", message);
        return "confirmation";
    }
}
