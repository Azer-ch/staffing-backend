package com.staffing.enterprise.service;

import com.staffing.employee.entity.Employee;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.exceptions.NameAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public Enterprise addEnterprise( Enterprise enterprise) throws NameAlreadyExistsException, EmailAlreadyExistsException {
        if (enterpriseRepository.existsByEnterpriseName(enterprise.getEnterpriseName())) {
            throw new NameAlreadyExistsException("enterprise name already exists");
        }
        if(enterpriseRepository.existsByEmail(enterprise.getEmail())){
            throw new EmailAlreadyExistsException("email already exists");
        }
        if(!roleRepository.existsRoleByName(RoleEnum.ROLE_ENTERPRISE)) {
            roleRepository.save(new Role(RoleEnum.ROLE_ENTERPRISE.toString()));
        }
        Role role = roleRepository.findRoleByName(RoleEnum.ROLE_ENTERPRISE);
        enterprise.addRole(role);
        enterprise.setActive(true);
        enterprise.setPassword(bCryptPasswordEncoder.encode(enterprise.getPassword()));
        return enterpriseRepository.save(enterprise);
    }
    @Transactional
    public Enterprise deleteEnterprise(String enterpriseName) throws NameAlreadyExistsException {
        if(!enterpriseRepository.existsByEnterpriseName(enterpriseName)) {
            throw new NameAlreadyExistsException("enterprise name does not exists");
        }
        Enterprise enterprise = enterpriseRepository.findByEnterpriseName(enterpriseName);
        enterprise.setActive(false);
        for(Employee employee : enterprise.getEmployees()) {
            employee.setActive(false);
        }
        return enterprise;
    }
}
