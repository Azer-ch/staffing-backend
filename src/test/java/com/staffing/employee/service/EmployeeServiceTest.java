package com.staffing.employee.service;

import com.staffing.employee.entity.Employee;
import com.staffing.employee.repository.EmployeeRepository;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import javassist.NotFoundException;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void addEmployeeValid(){
        Employee employee = new Employee();
        employee.setEmail("employee@employee.com");
        employee.setPassword("password");
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("enterprise");
        enterprise.setEmail("enterprise@nterprise.com");
        enterprise.setPassword("password");
        enterpriseRepository.save(enterprise);
        assertDoesNotThrow(() -> {
            employeeService.addEmployee(employee, "ROLE_ENGINEER", enterprise);
        });
    }
    @Test
    void addEmployeeInvalidEnterprise(){
        Employee employee1 = new Employee();
        employee1.setEmail("employee1@employee1.com");
        employee1.setPassword("password");
        Enterprise enterprise1 = new Enterprise();
        enterprise1.setEnterpriseName("enterprise1");
        enterprise1.setEmail("enterprise1@nterprise.com");
        enterprise1.setPassword("password");
        assertThrows(NotFoundException.class,() -> {
            employeeService.addEmployee(employee1, "ROLE_ENGINEER", enterprise1);
        });
    }
    @Test
    void addDuplicateEmployee() {
        Employee employee2 = new Employee();
        employee2.setEmail("employee2@employee2.com");
        employee2.setPassword("password");
        employeeRepository.save(employee2);
        Enterprise enterprise2 = new Enterprise();
        enterprise2.setEnterpriseName("enterprise2");
        enterprise2.setEmail("enterprise2@nterprise.com");
        enterprise2.setPassword("password");
        enterpriseRepository.save(enterprise2);
        assertThrows(EmailAlreadyExistsException.class, () -> {
            employeeService.addEmployee(employee2, "ROLE_ENGINEER", enterprise2);
        });
    }
}