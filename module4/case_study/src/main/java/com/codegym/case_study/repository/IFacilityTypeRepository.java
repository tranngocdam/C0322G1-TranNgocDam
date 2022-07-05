package com.codegym.case_study.repository;

import com.codegym.case_study.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
