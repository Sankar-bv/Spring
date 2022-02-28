package com.luv2code.springdemo;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on swimming";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
