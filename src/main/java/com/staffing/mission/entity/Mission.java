package com.staffing.mission.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.staffing.employee.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Mission")
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String client;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;
    @ManyToOne
    @JsonBackReference
    private Employee employee;

    public Mission() {
    }

    public Mission(String client, LocalDateTime startDate, LocalDateTime endDate, Employee employee) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employee=" + employee +
                '}';
    }
}
