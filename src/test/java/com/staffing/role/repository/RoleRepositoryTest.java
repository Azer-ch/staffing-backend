package com.staffing.role.repository;

import com.staffing.role.entity.Role;
import com.staffing.enums.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    void findRoleByName() {
        Role engineer = new Role(RoleEnum.ROLE_ENGINEER.toString());
        roleRepository.save(engineer);
        assertEquals(roleRepository.findRoleByName(RoleEnum.ROLE_ENGINEER), engineer);
    }

    @Test
    void existsRoleByName() {
        assertEquals(true, roleRepository.existsRoleByName(RoleEnum.ROLE_ADMIN));
    }
    @Test
    void addRolesValid(){
        Role admin = new Role(RoleEnum.ROLE_ADMIN.toString());
        Role enterprise = new Role(RoleEnum.ROLE_ENTERPRISE.toString());
        Role user = new Role(RoleEnum.ROLE_USER.toString());
        Role hr = new Role(RoleEnum.ROLE_HUMAN_RESOURCE.toString());
        roleRepository.saveAll(List.of(admin,enterprise,user,hr));
        assertEquals(4,roleRepository.count());
    }
}