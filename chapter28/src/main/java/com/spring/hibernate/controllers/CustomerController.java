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

    @GetMapping(value = "/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {

        customerService.deleteCustomer(customerId);

        return "redirect:/customer/list";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
