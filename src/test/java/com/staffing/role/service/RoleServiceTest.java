package com.staffing.role.service;

import com.staffing.exceptions.RoleAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RoleServiceTest {
    @Autowired RoleService roleService;
    @Test
    void testAddRoleValid(){
        Role admin = new Role(RoleEnum.ADMIN);
        assertDoesNotThrow(() ->roleService.addRole(admin));
    }
    @Test
    void testAddDuplicateRole(){
        Role admin = new Role(RoleEnum.ADMIN);
        assertDoesNotThrow(() ->roleService.addRole(admin));
        assertThrows(RoleAlreadyExistsException.class, () ->roleService.addRole(admin));
    }

}