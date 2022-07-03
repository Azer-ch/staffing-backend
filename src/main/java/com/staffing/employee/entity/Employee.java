package com.staffing.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.staffing.enterprise.entity.Enterprise;
import com.staffing.user.entity.User;

import javax.persistence.*;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    protected Long id;
    @Column
    protected boolean isActive;
    @ManyToOne
    @JsonBackReference
    protected Enterprise enterprise;

    public Employee(String email, String password) {
        super(email, password);
    }

    public Employee() {

    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
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
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
