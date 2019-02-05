package com.spring.hibernate.controllers;

import com.spring.hibernate.dao.CustomerDAO;
import com.spring.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(("/customer"))
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;

    @RequestMapping(value = "/list")
    public String getCustomers(Model model) {

        List<Customer> customers = customerDAO.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
