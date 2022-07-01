package com.staffing.admin.controller;

import com.staffing.admin.entity.Admin;
import com.staffing.admin.service.AdminService;
import com.staffing.exceptions.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<?> addAdmin(@Valid @RequestBody Admin admin) {
        try{
            return ResponseEntity.ok(adminService.addAdmin(admin));
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
