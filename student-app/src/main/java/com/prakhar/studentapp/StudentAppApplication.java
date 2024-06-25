package com.prakhar.studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@ComponentScan({"com.prakhar.studentapp.controller,com.prakhar.studentapp.service," +
		"com.prakhar.studentapp.security"})
@EntityScan({"com.prakhar.studentapp.entity"})
@EnableJpaRepositories({"com.prakhar.studentapp.repository"})
public class StudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

}
