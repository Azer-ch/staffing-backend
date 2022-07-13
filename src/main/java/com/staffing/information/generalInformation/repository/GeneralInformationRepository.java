package com.staffing.information.generalInformation.repository;

import com.staffing.information.generalInformation.entity.GeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralInformationRepository extends JpaRepository<GeneralInformation, Long> {
}
