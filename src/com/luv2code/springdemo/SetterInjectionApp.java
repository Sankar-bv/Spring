package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Coach theCoach = context.getBean("cricketcoach", Coach.class);
//		The above line will not work for literal values because the getter & other methods are only present in CricketCoach class not in Coach interface
		
		CricketCoach theCoach = context.getBean("cricketcoach", CricketCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//Call our methods to get the literal values
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		context.close();
	}

}
