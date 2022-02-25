package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		Coach theCoach = context.getBean("baseballcoach", Coach.class);
		Coach alphaCoach = context.getBean("baseballcoach", Coach.class);
		boolean result = theCoach == alphaCoach;
		System.out.println("Pointing to the same object : " + result);
		System.out.println("\nMemory location for theCoach : " + theCoach);
		System.out.println("\nMemory location for alphaCoach : " + alphaCoach);
		context.close();
	}

}
