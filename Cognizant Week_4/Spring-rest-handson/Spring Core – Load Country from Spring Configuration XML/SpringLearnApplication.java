package com.cognizant.spring_learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SpringLearnApplication {

	public static void main(String[] args) {
		displayDate();
	}

	public static void displayDate() {
		// Load the Spring context from XML
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

		// Get the SimpleDateFormat bean
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			// Parse date from string
			String dateString = "31/12/2018";
			Date date = format.parse(dateString);
			System.out.println("Parsed Date: " + date);
		} catch (Exception e) {
			System.out.println("Error parsing date: " + e.getMessage());
		}
	}
}
