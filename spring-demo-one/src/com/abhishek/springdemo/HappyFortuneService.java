package com.abhishek.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "getFortune() method called from HappyFortuneService class";
	}

}
