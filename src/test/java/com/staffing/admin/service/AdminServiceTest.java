package com.staffing.admin.service;

import com.staffing.admin.entity.Admin;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.role.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {
        @Autowired private AdminService adminService;
        @Test
        public void testCreateAdminValid() {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = "azer2022";
            String email = "azer@azer.com";
            String firstName = "Azer";
            String lastName = "Chabbar";
            ArrayList<Role> roles = new ArrayList<>();
            Admin admin = new Admin(email, password, firstName, lastName, roles);
            assertDoesNotThrow(()->adminService.addAdmin(admin));
        }

        @Test
        public void testCreateAdminEmailAlreadyExists(){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = "ahmed2022";
            String email = "ahmed@ahmed.com";
            String firstName = "Ahmed";
            String lastName = "Ben Amor";
            ArrayList<Role> roles = new ArrayList<>();
            Admin admin = new Admin(email, password, firstName, lastName, roles);
            assertDoesNotThrow(()->adminService.addAdmin(admin));
            assertThrows(EmailAlreadyExistsException.class, () -> adminService.addAdmin(admin));
        }
    }
