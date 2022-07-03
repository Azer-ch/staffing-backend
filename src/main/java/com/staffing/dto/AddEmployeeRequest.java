package com.staffing.dto;

import com.staffing.employee.entity.Employee;
import com.staffing.role.entity.Role;

public class AddEmployeeRequest {
    private String email;
    private String password;
    private String role;

    public AddEmployeeRequest(String email , String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
