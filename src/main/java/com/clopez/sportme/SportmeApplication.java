package com.clopez.sportme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.clopez.sportme.models.*"})
public class SportmeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SportmeApplication.class, args);
	}
}
