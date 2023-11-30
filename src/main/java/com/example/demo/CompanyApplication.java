package com.example.Company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class CompanyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(com.example.Company.CompanyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(com.example.Company.CompanyApplication.class);
	}

}
