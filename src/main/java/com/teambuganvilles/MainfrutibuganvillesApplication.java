package com.teambuganvilles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.teambuganvilles.model")
@ComponentScan(basePackages = {"com.teambuganvilles"})
public class MainfrutibuganvillesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainfrutibuganvillesApplication.class, args);
	}

}

