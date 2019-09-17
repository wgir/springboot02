package com.example.springboot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example"})
@EnableJpaRepositories("com.example.repository")
@EntityScan(basePackages = "com.example.entities")
@EnableJms

public class SpringBoot02Application {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Application.class, args);
	}

}
