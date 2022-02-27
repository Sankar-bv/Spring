package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class KabbadiCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	
	public KabbadiCoach() {
		System.out.println("KabbadiCoach: Inside default constructor");
	}

	// Define an init method
	@PostConstruct
	public void doStartupStuff() {
		System.out.println("KabbadiCoach: inside method doStartupStuff");
	}

	// Define a destroy method
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("KabbadiCoach: inside method doCleanupStuff");
	}
		
	@Override
	public String getDailyWorkout() {
		return "Practice Kabbadi for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		System.out.println(email);
		System.out.println(team);
		return fortuneService.getFortune();
	}

}
