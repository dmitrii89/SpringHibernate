package com.luv2code.springsecurity.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.user.CrmUser;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private Map<String, String> roles;

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @PostConstruct
    protected void loadRoles() {
        roles = new LinkedHashMap<>();
        roles.put("ROLE_EMPLOYEE", "Employee");
        roles.put("ROLE_MANAGER", "Manager");
        roles.put("ROLE_ADMIN", "Admin");
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());
        theModel.addAttribute("roles", roles);

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
                                          BindingResult theBindingResult,
                                          Model theModel) {

        String userName = theCrmUser.getUserName();
        logger.info("Processing registration form for: " + userName);

        // form validation
        if (theBindingResult.hasErrors()) {
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name already exists.");
            theModel.addAttribute("roles", roles);

            logger.warning("User name already exists.");
            return "registration-form";
        }

        // create user account
        userService.save(theCrmUser);

        logger.info("Successfully created user: " + userName);

        return "registration-confirmation";
    }
}
