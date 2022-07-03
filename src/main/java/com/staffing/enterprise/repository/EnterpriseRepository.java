package com.staffing.enterprise.repository;

import com.staffing.enterprise.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    public Enterprise findByEmail(String enterpriseName);
    public Boolean existsByEmail(String enterpriseName);
    public Enterprise findByEnterpriseName(String enterpriseName);
    public Boolean existsByEnterpriseName(String enterpriseName);
}
