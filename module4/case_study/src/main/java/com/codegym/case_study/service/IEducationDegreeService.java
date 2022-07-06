package com.codegym.case_study.service;

import com.codegym.case_study.model.EducationDegree;
import com.codegym.case_study.model.Employee;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}
