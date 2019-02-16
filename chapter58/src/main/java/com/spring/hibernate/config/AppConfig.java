package com.spring.hibernate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Dmitrii on 17.02.2019.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.spring.hibernate")
public class AppConfig {
}
