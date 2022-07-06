package com.codegym.case_study.repository;

import com.codegym.case_study.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
