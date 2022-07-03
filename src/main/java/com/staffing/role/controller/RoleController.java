package com.staffing.role.controller;

import com.staffing.role.entity.Role;
import com.staffing.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private  RoleService roleService;
    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<?> AddRole(@RequestBody  @Validated Role role)  {
        try{
            return ResponseEntity.ok(roleService.addRole(role));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
