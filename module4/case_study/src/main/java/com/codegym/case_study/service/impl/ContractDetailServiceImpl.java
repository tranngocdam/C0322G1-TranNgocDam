package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.ContractDetail;
import com.codegym.case_study.repository.IContractDetailRepository;
import com.codegym.case_study.repository.IContractRepository;
import com.codegym.case_study.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Integer id) {
        iContractDetailRepository.deleteById(id);
    }
}
