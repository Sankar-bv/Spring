package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
