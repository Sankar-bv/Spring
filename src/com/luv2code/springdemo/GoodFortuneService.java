package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class GoodFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your good day";
	}

}
