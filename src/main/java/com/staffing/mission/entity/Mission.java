package com.staffing.mission.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.staffing.employee.entity.Employee;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.enums.RoleEnum;
import com.staffing.enums.StatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Mission")
@Table(name = "mission")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @ManyToOne
    @JsonBackReference
    private Enterprise client;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;
    @ManyToMany
    private List<Employee> employees = new ArrayList<>();
    @Column
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    public Mission() {
        this.status = StatusEnum.PENDING;
    }

    public Mission(String title, Enterprise client, LocalDateTime startDate, LocalDateTime endDate, List<Employee> employees) {
        this.title = title;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employees = employees;
        this.status = StatusEnum.PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enterprise getClient() {
        return client;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClient(Enterprise client) {
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

    public List<Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mission{" + "id=" + id + ", client='" + client + '\'' + ", startDate=" + startDate + ", endDate=" + endDate + ", employees=" + employees + '}';
    }
}
