package com.staffing.information.contractualAdvantages.repository;

import com.staffing.information.contractualAdvantages.entity.ContractualAdvantages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractualAdvantagesRepository extends JpaRepository<ContractualAdvantages,Long> {
}
