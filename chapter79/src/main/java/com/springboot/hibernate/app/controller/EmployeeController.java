package com.springboot.hibernate.app.controller;

import com.springboot.hibernate.app.entity.Employee;
import com.springboot.hibernate.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dmitrii on 23.02.2019.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployees(Model model) {
        employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees-page";
    }
}
