package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycleApplicationContext.xml");
		Coach theCoach = context.getBean("baseballcoach", Coach.class);
		System.out.println("\n" + theCoach.getDailyWorkout());
		System.out.println("\n" + theCoach.getDailyFortune() + "\n");
		context.close();
	}

}
