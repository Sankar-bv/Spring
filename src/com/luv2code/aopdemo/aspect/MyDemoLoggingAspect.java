package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @AfterFinally on method: " + method);
	}
	
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing AfterThrowing on method: " + method);
		//Log the exception
		System.out.println("\n====>>> The exception is: " + theExc);
	}
	
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @AfterReturning on method: " + method);
		System.out.println("\n===>>> Result is: " + result);
		
		//Let's post process the data. Let's modify it
		for (Account account : result) {
			String theUpperCase = account.getName().toUpperCase();
			account.setName(theUpperCase);
		}
		System.out.println("\n===>>> After modify the result is: " + result);
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	//If we need to use pointcuts from different class we need to provide fully qualified class name in before annotation.
	public void beforeAddAdvice(JoinPoint theJoinPoint) {
		System.out.println("Executing @Before advice on method");
		
		//Display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		//Get the args
		Object[] args = theJoinPoint.getArgs();
		
		//Loop through args
		for (Object temp : args) {
			System.out.println(temp);
			
			if(temp instanceof Account) {
				//Downcast temp and print Account specific stuff
				Account theAccount = (Account) temp;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
	}
	
}
