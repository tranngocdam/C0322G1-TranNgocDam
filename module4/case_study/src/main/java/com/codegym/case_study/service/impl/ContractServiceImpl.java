package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.Contract;
import com.codegym.case_study.repository.IContractRepository;
import com.codegym.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {

    }

    @Override
    public void delete(Integer id) {
        iContractRepository.deleteById(id);
    }
}
