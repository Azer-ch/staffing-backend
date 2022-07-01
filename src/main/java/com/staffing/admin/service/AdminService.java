package com.staffing.admin.service;

import com.staffing.admin.entity.Admin;
import com.staffing.admin.repository.AdminRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Admin addAdmin(Admin admin) throws EmailAlreadyExistsException {
        if (adminRepository.existsAdminByEmail(admin.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        if(!roleRepository.existsRoleByName(RoleEnum.ADMIN)) {
            roleRepository.save(new Role(RoleEnum.ADMIN));
        }
        admin.setRole(roleRepository.findRoleByName(RoleEnum.ADMIN));
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
}