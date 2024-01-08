package com.soccatech.FootballManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.soccatech.FootballManagementSystem")
public class FootballManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballManagementSystemApplication.class, args);
	}

}
