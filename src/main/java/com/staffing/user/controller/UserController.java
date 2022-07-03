package com.staffing.user.controller;

import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.user.entity.User;
import com.staffing.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/admin")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> AddAdmin(@RequestBody @Valid User user) {
        try {
            return ResponseEntity.ok(userService.addAdmin(user));
        }catch (EmailAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
