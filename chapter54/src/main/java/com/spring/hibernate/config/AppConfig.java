package com.spring.hibernate.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.hibernate")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private Environment env;

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();

        try {
            ds.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));

        ds.setJdbcUrl(env.getProperty("jdbc.url"));
        ds.setUser(env.getProperty("jdbc.user"));
        ds.setPassword(env.getProperty("jdbc.password"));

        ds.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        ds.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        ds.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        ds.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return ds;
    }

    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);
        int intVal = Integer.parseInt(propVal);
        return intVal;
    }

}
