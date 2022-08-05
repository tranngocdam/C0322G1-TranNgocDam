package com.case_study.demo.service;

import com.case_study.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Integer id);

    Page<Contract> findContract(String name, Pageable pageable);
}
