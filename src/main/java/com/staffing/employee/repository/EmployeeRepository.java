package com.staffing.employee.repository;

import com.staffing.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByEmail(String email);
    public Boolean existsByEmail(String email);
}
