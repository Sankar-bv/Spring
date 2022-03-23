package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<Account>();
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
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
