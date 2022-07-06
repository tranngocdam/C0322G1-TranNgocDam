package com.codegym.case_study.service;

import com.codegym.case_study.model.CustomerType;
import com.codegym.case_study.model.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
}
