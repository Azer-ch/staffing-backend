package com.staffing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.staffing.enums.StatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MissionResponseDto {
    private Long id;

    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;
    private String client;
    private List<String> employees = new ArrayList<>();
    private StatusEnum status;

    public MissionResponseDto() {
        this.status = StatusEnum.PENDING;
    }

    public MissionResponseDto(String title, LocalDateTime startDate, LocalDateTime endDate, String client) {
        this.status = StatusEnum.PENDING;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    public MissionResponseDto(String title, LocalDateTime startDate, LocalDateTime endDate, String client, List<String> employeeList) {
        this.status = StatusEnum.PENDING;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.employees = employeeList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }
    public void addEmployee(String email){
        this.employees.add(email);
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
