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
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	//Create pointcut for getter methods
	private void getter() {}
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	//Create pointcut for setter methods
	private void setter() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	//Create pointcut: include package ... exclude getter/setter
	private void forDAOPackageNoGetterSetter() {}
	
	@Before("forDAOPackageNoGetterSetter()")
	//Applying pointcut declaration to advice
	public void beforeAddAdvice() {
		System.out.println("\nExecuting @Before advice on method");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	//Applying pointcut declaration to another advice
	public void performApiAnalytics() {
		System.out.println("Performing API Analytics");
	}
	
}
