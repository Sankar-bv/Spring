package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	@Pointcut("execution(public * *(..))")
	public void forDAOPackage() {}
	//The above code create a pointcut declaration
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	//Create pointcut for getter methods
	public void getter() {}
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	//Create pointcut for setter methods
	public void setter() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	//Create pointcut: include package ... exclude getter/setter
	public void forDaoPackageNoGetterSetter() {}
	
}
