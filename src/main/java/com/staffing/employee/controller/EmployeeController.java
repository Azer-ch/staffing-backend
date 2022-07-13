package com.staffing.employee.controller;

import com.staffing.dto.AddEmployeeRequest;
import com.staffing.employee.entity.Employee;
import com.staffing.employee.service.EmployeeService;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.exceptions.NameAlreadyExistsException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService employeeService;
    @Autowired private EnterpriseRepository enterpriseRepository;
    @PostMapping
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> addEmployee(@ModelAttribute @Valid AddEmployeeRequest addEmployeeRequest, @RequestParam("files")MultipartFile[] files, HttpServletRequest request) {
        Enterprise enterprise = enterpriseRepository.findByEmail(request.getUserPrincipal().getName());
        try{
            return ResponseEntity.ok(employeeService.addEmployee(addEmployeeRequest, addEmployeeRequest.getRole(),enterprise,files));
        }catch (EmailAlreadyExistsException | NotFoundException | IOException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
