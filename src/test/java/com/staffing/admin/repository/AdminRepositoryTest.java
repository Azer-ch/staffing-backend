package com.staffing.admin.repository;

import com.staffing.admin.entity.Admin;
import com.staffing.role.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;

    @Test
    void testCreateAdmins() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "azer2022";
        String email = "azer@azer.com";
        String firstName = "Azer";
        String lastName = "Chabbar";
        ArrayList<Role> roles = new ArrayList<>();
        Admin admin = new Admin(email, password, firstName, lastName, roles);
        String anotherPassword = "ahmed2022";
        String anotherEmail = "ahmed@ahmed.com";
        String anotherFirstName = "Ahmed";
        String anotherLastName = "Ben Amor";
        ArrayList<Role> anotherRoles = new ArrayList<>();
        Admin anotherAdmin = new Admin(anotherEmail, anotherPassword, anotherFirstName, anotherLastName, anotherRoles);
        adminRepository.saveAll(List.of(admin, anotherAdmin));
        assertEquals(2, adminRepository.count());
    }
    @Test
    void testFindAdminByEmail() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "azer2022";
        String email = "azer@azer.com";
        String firstName = "Azer";
        String lastName = "Chabbar";
        ArrayList<Role> roles = new ArrayList<>();
        Admin admin = new Admin(email, password, firstName, lastName, roles);
        adminRepository.save(admin);
        assertEquals(admin, adminRepository.findAdminByEmail(email));
    }
}