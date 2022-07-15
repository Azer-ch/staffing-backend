package com.staffing.enterprise.service;

import com.staffing.dto.AddEnterpriseRequest;
import com.staffing.employee.entity.Employee;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.exceptions.NameAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public Enterprise addEnterprise(AddEnterpriseRequest enterprise) throws Exception {
        if(!Objects.equals(enterprise.getPassword(), enterprise.getConfirmPassword()))
            throw new Exception("Passwords do not match");
        if (enterpriseRepository.existsByEnterpriseName(enterprise.getName())) {
            throw new NameAlreadyExistsException("enterprise name already exists");
        }
        if(enterpriseRepository.existsByEmail(enterprise.getEmail())){
            throw new EmailAlreadyExistsException("email already exists");
        }
        if(!roleRepository.existsRoleByName(RoleEnum.ROLE_ENTERPRISE)) {
            roleRepository.save(new Role(RoleEnum.ROLE_ENTERPRISE.toString()));
        }
        Enterprise newEnterprise = new Enterprise(enterprise.getName(), enterprise.getEmail(), enterprise.getPassword());
        Role role = roleRepository.findRoleByName(RoleEnum.ROLE_ENTERPRISE);
        newEnterprise.addRole(role);
        newEnterprise.setActive(true);
        newEnterprise.setPassword(bCryptPasswordEncoder.encode(newEnterprise.getPassword()));
        return enterpriseRepository.save(newEnterprise);
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
