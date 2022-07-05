package com.codegym.case_study.repository;

import com.codegym.case_study.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
