package com.codegym.case_study.service;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);

    void delete(Integer id);
}
