package com.example.springtrainingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.TimeZone;

@SpringBootApplication
public class SpringTrainingDemoApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", String.valueOf(TimeZone.getTimeZone("CST")));
		SpringApplication.run(SpringTrainingDemoApplication.class, args);

	}

}
