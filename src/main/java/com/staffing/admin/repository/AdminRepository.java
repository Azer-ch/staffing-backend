package com.staffing.admin.repository;

import com.staffing.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Admin findAdminByEmail(String email);
    boolean existsAdminByEmail(String email);
}
