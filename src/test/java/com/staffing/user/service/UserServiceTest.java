package com.staffing.user.service;

import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void addAdminAlreadyExists() {
        User admin = new User();
        admin.setEmail("azer@azer.com");
        admin.setPassword("12345678");
        assertThrows(EmailAlreadyExistsException.class, () -> userService.addAdmin(admin));
    }

    @Test
    void addAdminValid() {
        User admin = new User();
        admin.setEmail("ahmed@ahmed.com");
        admin.setPassword("12345678");
        assertDoesNotThrow(() -> userService.addAdmin(admin));
    }
    @Test
    void CreateSuperUser(){
        assertDoesNotThrow(() -> userService.FindUserByEmail("azer@azer.com"));
    }
}