package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginngAspect {

	//Setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//Setup pointcut declarations
	@Pointcut("execution(* com.luv2code..springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code..springdemo.controller.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code..springdemo.controller.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//Display methods we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> In @Before: calling method: " + theMethod);
		
		//Display the arguments to the method

		//Get the arguments
		Object[] args = theJoinPoint.getArgs();

		//Loop thru and display args
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
	}
	
	// Add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		//Display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);

		//Display data returned
		myLogger.info("=====>> result: " + theResult);

	}
	
}
