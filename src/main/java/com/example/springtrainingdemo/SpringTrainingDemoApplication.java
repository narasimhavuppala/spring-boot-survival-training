package com.example.springtrainingdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringTrainingDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringTrainingDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello ");
	}
}
