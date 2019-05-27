package com.abhishek.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// new fields for email address and team
	
	private String emailAddress;
	private String team;
	
	// no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter method - setTeam");
		this.team = team;
	}

	// setter method	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Bowling practice for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
