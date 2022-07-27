package com.staffing.information.param.repository;

import com.staffing.information.param.entity.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamRepository extends JpaRepository<Param, Long> {
    boolean existsByName(String name);
}
