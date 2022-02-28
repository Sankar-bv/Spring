package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigurationNoXMLDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Sportconfig.class);
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
//		To run only manually defined bean we should comment @ComponentScan in SportConfig class
		context.close();
	}

}
