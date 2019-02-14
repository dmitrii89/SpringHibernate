package com.spring.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String MANAGER = "MANAGER";
    private static final String ADMIN = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles(EMPLOYEE))
                .withUser(users.username("mary").password("test123").roles(EMPLOYEE, MANAGER))
                .withUser(users.username("susan").password("test123").roles(EMPLOYEE, ADMIN));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole(EMPLOYEE)
                .antMatchers("/leaders/**").hasRole(MANAGER)
                .antMatchers("/systems/**").hasRole(ADMIN)
                .and()
                .formLogin()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
