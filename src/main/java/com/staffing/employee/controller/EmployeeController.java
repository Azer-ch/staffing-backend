package com.staffing.employee.controller;

import com.staffing.dto.AddEmployeeRequest;
import com.staffing.employee.entity.Employee;
import com.staffing.employee.service.EmployeeService;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService employeeService;
    @Autowired private EnterpriseRepository enterpriseRepository;
    @PostMapping
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> addEmployee(@RequestBody @Valid AddEmployeeRequest addEmployeeRequest, HttpServletRequest request) {
        Enterprise enterprise = enterpriseRepository.findByEmail(request.getUserPrincipal().getName());
        Employee employee = new Employee(addEmployeeRequest.getEmail(),addEmployeeRequest.getPassword());
        try{
            return ResponseEntity.ok(employeeService.addEmployee(employee, addEmployeeRequest.getRole(),enterprise));
        }catch (Exception NameAlreadyExistsException) {
            return ResponseEntity.badRequest().body(NameAlreadyExistsException.getMessage());
        }
    }
}
