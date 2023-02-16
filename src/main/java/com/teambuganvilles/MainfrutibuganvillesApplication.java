package com.teambuganvilles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan("com.teambuganvilles.model")
@ComponentScan(basePackages = {"com.teambuganvilles"})
public class MainfrutibuganvillesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainfrutibuganvillesApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {

			public void addCorsMapping(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}

