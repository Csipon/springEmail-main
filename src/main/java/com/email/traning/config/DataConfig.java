package com.email.traning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;

/**
 * Created by Smeet on 06.06.2017.
 */
@Configuration
@PropertySource("classpath:local.properties")
public class DataConfig {

    private static final String DRIVER = "spring.datasource.local.driver";
    private static final String USERNAME = "spring.datasource.local.username";
    private static final String PASSWORD = "spring.datasource.password";
    private static final String URL = "spring.datasource.jdbcUrl";

    @Resource
    private Environment env;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty(URL));
        dataSource.setDriverClassName(env.getProperty(DRIVER));
        dataSource.setUsername(env.getProperty(USERNAME));
        dataSource.setPassword(env.getProperty(PASSWORD));
        return dataSource;
    }
}
