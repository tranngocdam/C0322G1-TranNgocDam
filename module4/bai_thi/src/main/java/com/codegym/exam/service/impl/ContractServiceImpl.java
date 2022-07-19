package com.codegym.exam.service.impl;

import com.codegym.exam.model.Contract;
import com.codegym.exam.model.Room;
import com.codegym.exam.repository.IContractRepository;
import com.codegym.exam.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = this.iContractRepository.findAll();
        for (Contract contract: contractList) {
            switch (contract.getCostTime()) {
                case "3 Tháng":
                    contract.setTotalMoney(contract.getRoom().getPrice() * 3);
                    break;
                case "6 Tháng":
                    contract.setTotalMoney(contract.getRoom().getPrice() * 6);
                    break;
                case "12 Tháng":
                    contract.setTotalMoney(contract.getRoom().getPrice() * 12);
                    break;
                default:
                    contract.setTotalMoney(0.0);
                    break;
            }
        }
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }

    @Override
    public void delete(String contractCode) {
        this.iContractRepository.delete(this.iContractRepository.findById(contractCode));
    }

    @Override
    public Contract findById(String contractCode) {
        return this.iContractRepository.findById(contractCode);
    }
}
