package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;
	
	//Contructor Injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on baseball";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//Add an init method
	public void doStartupStuff() {
		System.out.println("BaseballCoach: inside method doStartupStuff");
	}
	
	//Add an destroy method
	public void doCleanupStuff() {
		System.out.println("BaseballCoach: inside method doCleanupStuff");
	}
	
}
