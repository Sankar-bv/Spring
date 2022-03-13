package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
		//getClass() will gives us the class name for display
	}
	
	public void doWork() {
		System.out.println(getClass() + ": I'm going to work");
	}

	public String getName() {
		System.out.println("\n" + getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("\n" + getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("\n" + getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("\n" + getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
