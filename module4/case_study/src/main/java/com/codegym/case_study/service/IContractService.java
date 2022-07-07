package com.codegym.case_study.service;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.Customer;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    void delete(Integer id);
}
