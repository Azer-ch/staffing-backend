package com.staffing.leave.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.staffing.employee.entity.Employee;
import com.staffing.enums.LeaveEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_leave")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LeaveEnum type;
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

    public Leave(LeaveEnum type, LocalDateTime startDate, LocalDateTime endDate, Employee employee) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Leave() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LeaveEnum getType() {
        return type;
    }

    public void setType(LeaveEnum type) {
        this.type = type;
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
        return "Leave{" +
                "id=" + id +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employee=" + employee +
                '}';
    }
}
