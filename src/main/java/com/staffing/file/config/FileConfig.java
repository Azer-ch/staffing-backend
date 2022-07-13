package com.staffing.file.config;

import com.staffing.file.service.FileService;
import com.staffing.user.entity.User;
import com.staffing.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
    @Bean
    CommandLineRunner initFiles(FileService fileService) {
        return args -> {
            fileService.init();
        };
    }
}
