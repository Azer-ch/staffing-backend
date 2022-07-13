package com.staffing.role.service;

import com.staffing.exceptions.RoleAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.enums.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoleServiceTest {
    @Autowired
    private RoleService roleService;
    @Test
    void addRoleInvalid() {
        assertThrows(RoleAlreadyExistsException.class, () -> {
            roleService.addRole(new Role(RoleEnum.ROLE_ADMIN.toString()));
        });
    }
    @Test
    void addRoleValid(){
        assertDoesNotThrow(() -> {
            roleService.addRole(new Role(RoleEnum.ROLE_USER.toString()));
        });
    }
}