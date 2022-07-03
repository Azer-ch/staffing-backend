package com.staffing.enterprise.controller;

import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enterprise.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired private EnterpriseService enterpriseService;
    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<?> addEnterprise(@RequestBody @Valid Enterprise enterprise) {
        try{
            return ResponseEntity.ok(enterpriseService.addEnterprise(enterprise));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @DeleteMapping ("/{enterprise}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<?> DeleteEnterprise(@PathVariable String enterprise) {
        try{
            return ResponseEntity.ok(enterpriseService.deleteEnterprise(enterprise));
        }catch (Exception NameAlreadyExistsException) {
            return ResponseEntity.badRequest().body(NameAlreadyExistsException.getMessage());
        }
    }
}
