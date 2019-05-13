package com.abdullah.khan.cblpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
// @ComponentScan("com.abdullah.khan.firstApplicationRestL50")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}
	//http://localhost:8080/browser/index.html#http://localhost:8080/actuator/beans
	@Profile("prod")//this bean activeonly prod profile
	@Bean
	public String dummy() {
		return "something";
	}
}