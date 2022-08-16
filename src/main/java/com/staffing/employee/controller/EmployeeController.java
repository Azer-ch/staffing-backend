package com.staffing.employee.controller;

import com.staffing.dto.AddEmployeeRequest;
import com.staffing.employee.service.EmployeeService;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @PostMapping("/add")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> addEmployee(@ModelAttribute @Valid AddEmployeeRequest addEmployeeRequest, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        Enterprise enterprise = enterpriseRepository.findByEmail(request.getUserPrincipal().getName());
        try {
            return ResponseEntity.ok(employeeService.addEmployee(addEmployeeRequest, addEmployeeRequest.getRole(), enterprise, files));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @GetMapping("/{id}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.getEmployee(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
