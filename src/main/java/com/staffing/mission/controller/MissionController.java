package com.staffing.mission.controller;

import com.staffing.dto.AddMissionRequest;
import com.staffing.mission.entity.Mission;
import com.staffing.mission.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/mission")
public class MissionController {
    @Autowired
    private MissionService missionService;
    @RolesAllowed({"ROLE_ENTERPRISE"})
    @PostMapping("/add")
    public ResponseEntity<?> addMission(@ModelAttribute @Valid AddMissionRequest mission) {
        try {
            return ResponseEntity.ok(missionService.addMission(mission));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    @RolesAllowed({"ROLE_ENGINEER"})
    public ResponseEntity<?> getAllLeavesByEmployee(HttpServletRequest request) {
        try {
            return ResponseEntity.ok(missionService.getAllMissionsByEmployee(request.getUserPrincipal().getName()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
