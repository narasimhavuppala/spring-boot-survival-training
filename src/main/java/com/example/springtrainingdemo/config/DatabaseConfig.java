package com.example.springtrainingdemo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@Profile("postgress")
@EnableAutoConfiguration(exclude = H2ConsoleAutoConfiguration.class)
public class DatabaseConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource createPostgressConnection(){
        HikariConfig config=new HikariConfig();
        config.setUsername(environment.getProperty("username"));
        config.setPassword(environment.getProperty("password"));
        config.setJdbcUrl(environment.getProperty("url"));
        return new HikariDataSource(config);
    }

}
