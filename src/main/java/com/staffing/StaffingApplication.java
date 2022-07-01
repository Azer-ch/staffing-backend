package com.staffing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.staffing")
public class StaffingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffingApplication.class, args);
	}

}
