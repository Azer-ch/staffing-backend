package com.staffing.mission.controller;

import com.staffing.dto.AddMissionRequest;
import com.staffing.enums.StatusEnum;
import com.staffing.mission.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    public ResponseEntity<?> getAcceptedMissionsByEmployee(HttpServletRequest request) {
        try {
            return ResponseEntity.ok(missionService.getMissionsByEmployee(request.getUserPrincipal().getName(), StatusEnum.ACCEPTED));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/validate/{id}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> validateMission(HttpServletRequest request,@PathVariable Long id){
        try {
            return ResponseEntity.ok(missionService.validateMission(id,request.getUserPrincipal().getName()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/edit/{id}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> validateMission(@ModelAttribute @Valid AddMissionRequest mission,@PathVariable Long id){
        try {
            return ResponseEntity.ok(missionService.editMission(id,mission));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> deleteMission(HttpServletRequest request,@PathVariable Long id){
        try {
            return ResponseEntity.ok(missionService.deleteMission(id,request.getUserPrincipal().getName()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{status}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> getMissionsByEnterprise(HttpServletRequest request, @PathVariable String status) {
        try {
            return ResponseEntity.ok(missionService.getMissionsByEnterprise(request.getUserPrincipal().getName(), StatusEnum.valueOf(status)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/employees/{id}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> getEmployeesByMission(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(missionService.getEmployeesByMission(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/enterprise/{id}")
    @RolesAllowed({"ROLE_ENTERPRISE"})
    public ResponseEntity<?> getEnterpriseByMission(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(missionService.getClientByMission(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
