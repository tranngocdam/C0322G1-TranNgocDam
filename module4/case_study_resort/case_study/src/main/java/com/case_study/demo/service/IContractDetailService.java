package com.case_study.demo.service;

import com.case_study.demo.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

//    void delete(Integer id);
}
