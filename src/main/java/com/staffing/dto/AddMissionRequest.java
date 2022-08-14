package com.staffing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.staffing.employee.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddMissionRequest {
    private String title;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;
    private String client;
    private List<String> employeeList = new ArrayList<>();

    public AddMissionRequest() {
    }

    public AddMissionRequest(String title, LocalDateTime startDate, LocalDateTime endDate, String client) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    public AddMissionRequest(String title, LocalDateTime startDate, LocalDateTime endDate, String client, List<String> employeeList) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.employeeList = employeeList;
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

    public List<String> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<String> employeeList) {
        this.employeeList = employeeList;
    }
}
