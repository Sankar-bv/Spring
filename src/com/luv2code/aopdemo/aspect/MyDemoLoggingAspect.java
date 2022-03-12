package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(public * *(..))")
	private void forDAOPackage() {}
	//The above code create a pointcut declaration
	
	@Before("forDAOPackage()")
	//Applying pointcut declaration to advice
	public void beforeAddAdvice() {
		System.out.println("\nExecuting @Before advice on method");
	}
	
	@Before("forDAOPackage()")
	//Applying pointcut declaration to another advice
	public void performApiAnalytics() {
		System.out.println("Performing API Analytics");
	}
	
}
