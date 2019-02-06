package com.spring.hibernate.controllers;

import com.spring.hibernate.entity.Customer;
import com.spring.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(("/customer"))
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/list")
    public String getCustomers(Model model) {

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping(value = "/showFormForAdd")
    public String addCustomerForm(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping(value = "/showFormForUpdate")
    public String updateCustomerForm(@RequestParam("customerId") int customerId, Model model) {

        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }
}
