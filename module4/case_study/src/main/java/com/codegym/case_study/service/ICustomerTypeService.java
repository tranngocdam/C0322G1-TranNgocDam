package com.codegym.case_study.service;

import com.codegym.case_study.model.CustomerType;
import com.codegym.case_study.model.Facility;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
