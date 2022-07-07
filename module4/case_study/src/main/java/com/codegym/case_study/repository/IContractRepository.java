package com.codegym.case_study.repository;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value="select * from contract", nativeQuery=true)
    public List<Contract> findAll();
}
