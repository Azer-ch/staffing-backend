package com.staffing.enterprise.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.staffing.employee.entity.Employee;
import com.staffing.mission.entity.Mission;
import com.staffing.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "enterprise")
@Table(name = "enterprise", uniqueConstraints = {@UniqueConstraint(name = "enterprise_name_unique", columnNames = "enterprise_name")})
public class Enterprise extends User {
    @Column
    protected boolean isActive;
    @Column(name = "enterprise_name", nullable = false, length = 100)
    protected String enterpriseName;
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
    @JsonManagedReference
    protected List<Employee> employees = new ArrayList<Employee>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference
    protected List<Mission> missions = new ArrayList<Mission>();

    public Enterprise(String enterpriseName, String email, String password) {
        this.enterpriseName = enterpriseName;
        this.email = email;
        this.password = password;
    }

    public Enterprise() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
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

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        return "Enterprise{" + "enterpriseName='" + enterpriseName + '\'' + ", id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", roles=" + roles + '\'' + ", isActive=" + isActive + '\'' + ", employees=" + employees + '}';
    }

}
