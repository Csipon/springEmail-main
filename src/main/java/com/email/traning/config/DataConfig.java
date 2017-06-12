package com.email.traning.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Smeet on 06.06.2017.
 */
@Configuration
@PropertySource({"classpath:application.properties", "classpath:local.properties"})
public class DataConfig {

    private static final String USERNAME = "spring.datasource.local.username";
    private static final String PASSWORD = "spring.datasource.local.password";
    private static final String URL = "spring.datasource.local.jdbcUrl";

    private static final String SPRING_DATASOURCE_HIKARI_USERNAME = "spring.datasource.hikari.username";
    private static final String SPRING_DATASOURCE_HIKARI_PASSWORD = "spring.datasource.hikari.password";
    private static final String SPRING_DATASOURCE_HIKARI_JDBC_URL = "spring.datasource.hikari.jdbcUrl";
    private static final String SPRING_DATASOURCE_HIKARI_POOL_NAME = "spring.datasource.hikari.pool-name";
    private static final String SPRING_DATASOURCE_HIKARI_DRIVER_CLASS_NAME = "spring.datasource.hikari.driverClassName";
    private static final String SPRING_DATASOURCE_HIKARI_CONNECTION_TEST_QUERY = "spring.datasource.hikari.connection-test-query";
    private static final String SPRING_DATASOURCE_HIKARI_MAXIMUM_POOL_SIZE = "spring.datasource.hikari.maximum-pool-size";
    private static final String SPRING_DATASOURCE_HIKARI_MINIMUM_IDLE = "spring.datasource.hikari.minimum-idle";
    private static final String SPRING_DATASOURCE_HIKARI_IDLE_TIMEOUT = "spring.datasource.hikari.idle-timeout";
    private static final String SPRING_DATASOURCE_HIKARI_CONNECTION_TIMEOUT = "spring.datasource.hikari.connection-timeout";
    private static final String SPRING_DATASOURCE_HIKARI_MAX_LIFETIME = "spring.datasource.hikari.max-lifetime";

    @Resource
    private Environment env;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();

        if (env.acceptsProfiles("!production")) {
            config.setUsername(env.getProperty(USERNAME));
            config.setPassword(env.getProperty(PASSWORD));
            config.setJdbcUrl(env.getProperty(URL));

        } else {
            config.setUsername(env.getProperty(SPRING_DATASOURCE_HIKARI_USERNAME));
            config.setPassword(env.getProperty(SPRING_DATASOURCE_HIKARI_PASSWORD));
            config.setJdbcUrl(env.getProperty(SPRING_DATASOURCE_HIKARI_JDBC_URL));
        }

        config.setPoolName(env.getProperty(SPRING_DATASOURCE_HIKARI_POOL_NAME));
        config.setDriverClassName(env.getProperty(SPRING_DATASOURCE_HIKARI_DRIVER_CLASS_NAME));
        config.setConnectionTestQuery(env.getProperty(SPRING_DATASOURCE_HIKARI_CONNECTION_TEST_QUERY));
        config.setMaximumPoolSize(Integer.valueOf(env.getProperty(SPRING_DATASOURCE_HIKARI_MAXIMUM_POOL_SIZE)));
        config.setMinimumIdle(Integer.valueOf(env.getProperty(SPRING_DATASOURCE_HIKARI_MINIMUM_IDLE)));
        config.setIdleTimeout(Long.valueOf(env.getProperty(SPRING_DATASOURCE_HIKARI_IDLE_TIMEOUT)));
        config.setConnectionTimeout(Long.valueOf(env.getProperty(SPRING_DATASOURCE_HIKARI_CONNECTION_TIMEOUT)));
        config.setMaxLifetime(Long.valueOf(env.getProperty(SPRING_DATASOURCE_HIKARI_MAX_LIFETIME)));

        return new HikariDataSource(config);
    }
}
