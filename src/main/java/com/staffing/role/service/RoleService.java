package com.staffing.role.service;

import com.staffing.exceptions.RoleAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role addRole(Role role) throws RoleAlreadyExistsException {
        if (roleRepository.existsRoleByName(role.getName())) {
            throw new RoleAlreadyExistsException();
        }
        return roleRepository.save(role);
    }
}
