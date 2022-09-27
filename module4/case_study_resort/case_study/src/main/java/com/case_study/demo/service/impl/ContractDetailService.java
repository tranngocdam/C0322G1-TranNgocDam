package com.case_study.demo.service.impl;

import com.case_study.demo.model.ContractDetail;
import com.case_study.demo.repository.IContractDetailRepository;
import com.case_study.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

//    @Override
//    public void delete(Integer id) {
//
//    }
}
