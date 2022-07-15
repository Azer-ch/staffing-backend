package com.staffing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "com.staffing")
public class StaffingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffingApplication.class, args);
    }

}
