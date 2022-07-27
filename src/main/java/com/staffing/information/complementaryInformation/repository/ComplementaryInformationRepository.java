package com.staffing.information.complementaryInformation.repository;

import com.staffing.information.complementaryInformation.entity.ComplementaryInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplementaryInformationRepository extends JpaRepository<ComplementaryInformation,Long> {
}
