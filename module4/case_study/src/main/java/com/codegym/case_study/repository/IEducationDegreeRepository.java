package com.codegym.case_study.repository;

import com.codegym.case_study.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
