package com.staffing.leave.controller;

import com.staffing.leave.entity.Leave;
import com.staffing.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/add")
    @RolesAllowed({"ROLE_ENGINEER"})
    public ResponseEntity<?> addLeave(@ModelAttribute @Valid Leave leave, HttpServletRequest request) {
        try {
            return ResponseEntity.ok(leaveService.addLeave(leave, request.getUserPrincipal().getName()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    @RolesAllowed({"ROLE_ENGINEER"})
    public ResponseEntity<?> getAllLeavesByEmployee(HttpServletRequest request) {
        try {
            return ResponseEntity.ok(leaveService.getAllLeavesByEmployee(request.getUserPrincipal().getName()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
