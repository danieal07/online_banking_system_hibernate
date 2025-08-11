package com.cognizant.countrycodeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml") // loads XML beans
public class CountryCodeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CountryCodeServiceApplication.class, args);
	}
}
