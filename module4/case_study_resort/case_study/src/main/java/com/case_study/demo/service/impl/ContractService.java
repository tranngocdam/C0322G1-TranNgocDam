package com.case_study.demo.service.impl;

import com.case_study.demo.model.Contract;
import com.case_study.demo.repository.IContractRepository;
import com.case_study.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void delete(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findContract(String name, Pageable pageable) {
        return iContractRepository.findContractByCustomer("%"+name+"%", pageable);
    }
}
