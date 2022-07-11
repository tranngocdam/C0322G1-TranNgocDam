package com.codegym.case_study.service;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Employee;
import com.codegym.case_study.model.Facility;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);
}
