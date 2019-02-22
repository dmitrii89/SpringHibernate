package com.springboot.hibernate.app.controller;

import com.springboot.hibernate.app.model.Employee;
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

    @PostConstruct
    private void buildEmployees() {
        Employee emp1 = new Employee(1, "John", "Jones", "jj@mail.com");
        Employee emp2 = new Employee(1, "Daniel", "Cormie", "dc@mail.com");
        Employee emp3 = new Employee(1, "Khabib", "Nurmagomedov", "kn@mail.com");
        Employee emp4 = new Employee(1, "Conor", "McGregor", "cm@mail.com");
        employees = Arrays.asList(emp1, emp2, emp3, emp4);
    }

    @GetMapping("/list")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "employees-page";
    }
}
