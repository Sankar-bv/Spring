package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
		context.close();
	}

}
