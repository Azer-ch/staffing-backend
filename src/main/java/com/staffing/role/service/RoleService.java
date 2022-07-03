package com.staffing.role.service;

import com.staffing.exceptions.RoleAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private  RoleRepository roleRepository;

    public Role addRole(Role role) throws RoleAlreadyExistsException {
        if (roleRepository.existsRoleByName(RoleEnum.valueOf(role.getName()))) {
            throw new RoleAlreadyExistsException();
        }
        return roleRepository.save(role);
    }
}
