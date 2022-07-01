package com.staffing.role.repository;

import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(RoleEnum name);
    boolean existsRoleByName(RoleEnum name);
}
