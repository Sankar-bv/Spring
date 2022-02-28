package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")	// To load properties file and inject literal values in the code
public class Sportconfig {

	//Define bean for our good fortune service
	@Bean
	public FortuneService goodFortuneService() {
		return new GoodFortuneService();
	}
	
	//Define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(goodFortuneService());
	}
}
