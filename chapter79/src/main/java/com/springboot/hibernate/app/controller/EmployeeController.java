package com.springboot.hibernate.app.controller;

import com.springboot.hibernate.app.entity.Employee;
import com.springboot.hibernate.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "employees/directory";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }
}
