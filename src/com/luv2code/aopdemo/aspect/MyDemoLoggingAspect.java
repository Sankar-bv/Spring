package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void addAccount())")
	//Will match for all classes which has addAccount method
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	//Will only match on addAccount for the specific class i.e. The below method will run only for AccountDAO class
//	public void beforeAddAccountAdvice() {
//		System.out.println("Executing @Before advice on addAccount()");
//	}
	
	@Before("execution(public * add*(com.luv2code.aopdemo.Account, ..))")
	//Will match method starting with "add" name in any class.
	//Will match with any return type for add methods with the use of wildcards i.e. (*).
	//Will match on any number of arguments by use of param wildcards i.e. (..)
	//@Before("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	//If we provide only two dots in paranthesis i.e. method name(..) It will match for any number of arguments and also for no arguments.
	public void beforeAddAdvice() {
		System.out.println("Executing @Before advice on addAccount()");
	}
	
}
