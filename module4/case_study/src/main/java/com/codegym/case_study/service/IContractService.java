package com.codegym.case_study.service;

import com.codegym.case_study.dto.ContractDto;
import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void delete(Integer id);

    Page<ContractDto> getContractDto(Pageable pageable);
}
