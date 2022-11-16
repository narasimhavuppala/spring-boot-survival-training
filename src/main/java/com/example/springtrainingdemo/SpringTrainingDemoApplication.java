package com.example.springtrainingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringTrainingDemoApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", String.valueOf(TimeZone.getTimeZone("CST")));
		SpringApplication.run(SpringTrainingDemoApplication.class, args);

	}

}
