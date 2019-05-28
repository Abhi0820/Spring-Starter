package com.abhishek.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: Inside method doMyStartupStuff");
	}
	
	// add destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: Inside method doMyCleanupStuff");
	}
	
}
