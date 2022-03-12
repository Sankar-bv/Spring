package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {
		System.out.println(getClass() + ": Doing Stuff: Adding a membership account");
		return true;
	}
	
}
