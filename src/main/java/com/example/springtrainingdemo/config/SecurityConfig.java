package com.example.springtrainingdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig  {

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ram").password(passwordEncoder().encode("ram123")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("ravan").password(passwordEncoder().encode("ravan123")).roles("USER");
        auth.inMemoryAuthentication().withUser("kans").password(passwordEncoder().encode("kans123")).roles("USER");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
       return  http
                .authorizeRequests().anyRequest().authenticated().and().build();
               // .requestMatchers("/**")
               // .authenticated().and().build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
