package com.abhishek.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve the bean from the container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// print out the result
		System.out.println("\nPointing to the same bean/object: " + result);
		System.out.println("\nMemory Location of theCoach: " + theCoach);
		System.out.println("\nMemory Location of alphaCoach: " + alphaCoach + "\n");
		
		// close the context
		context.close();
	}

}
