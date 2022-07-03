package com.staffing.user.createSuperUser;

import com.staffing.role.service.RoleService;
import com.staffing.user.entity.User;
import com.staffing.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSuperUser {
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            User SuperUser = new User("azer@azer.com","azer2000");
            userService.addAdmin(SuperUser);
        };
    }
}
