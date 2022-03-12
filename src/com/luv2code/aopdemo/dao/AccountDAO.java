package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean flag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
		//getClass() will gives us the class name for display
	}
	
	public void doWork() {
		System.out.println(getClass() + ": I'm going to work");
	}
	
}
