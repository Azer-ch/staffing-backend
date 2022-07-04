package com.staffing.employee.service;

import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.exceptions.NameAlreadyExistsException;
import com.staffing.role.entity.Role;
import com.staffing.role.enums.RoleEnum;
import com.staffing.role.repository.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    public Employee addEmployee(Employee employee, String roleName, Enterprise enterprise) throws NotFoundException, EmailAlreadyExistsException {
        if(employeeRepository.existsByEmail(employee.getEmail())){
            throw new EmailAlreadyExistsException("email already exists");
        }
        if(!roleRepository.existsRoleByName(RoleEnum.valueOf(roleName))) {
            roleRepository.save(new Role(roleName));
        }
        if(!enterpriseRepository.existsByEnterpriseName(enterprise.getEnterpriseName())) {
            throw new NotFoundException("enterprise not found");
        }
        Role role = roleRepository.findRoleByName(RoleEnum.valueOf(roleName));
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.addRole(role);
        employee.setEnterprise(enterprise);
        employee.setActive(true);
        enterprise.addEmployee(employee);
        return employeeRepository.save(employee);
    }
}
