package com.codegym.case_study.repository;

import com.codegym.case_study.model.Employee;
import com.codegym.case_study.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value="select * from employee", nativeQuery=true)
    public List<Employee> findAll();
}
