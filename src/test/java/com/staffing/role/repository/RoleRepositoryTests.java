package com.staffing.role.repository;

import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RoleRepositoryTests {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateRoles() {
        Role admin = new Role(RoleEnum.ADMIN);
        Role user = new Role(RoleEnum.USER);
        roleRepository.saveAll(List.of(admin,user));
        assertEquals(2, roleRepository.count());
    }
    @Test
    public void testFindRoleByName() {
        Role admin = new Role(RoleEnum.ADMIN);
        roleRepository.save(admin);
        assertEquals(RoleEnum.ADMIN, roleRepository.findRoleByName(RoleEnum.ADMIN).getName());
    }
}


