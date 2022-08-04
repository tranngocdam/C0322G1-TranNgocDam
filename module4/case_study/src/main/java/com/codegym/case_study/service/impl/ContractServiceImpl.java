package com.codegym.case_study.service.impl;

import com.codegym.case_study.dto.ContractDto;
import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.ContractDetail;
import com.codegym.case_study.repository.IContractRepository;
import com.codegym.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
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
    public Page<ContractDto> getContractDto(Pageable pageable) {
        Page<Contract> contracts=this.iContractRepository.findAll(pageable);
        List<ContractDto> contractDtos=new ArrayList<>();
        Page<ContractDto> contractDtoPage;
        for (int i=0; i<contracts.getContent().size(); i++){
            int total = 0;
            for (ContractDetail c: contracts.getContent().get(i).getContractDetailList()) {
                total+=c.getQuantity()*c.getAttachFacility().getCost();
            }
            ContractDto contractDto=new ContractDto(
                    contracts.getContent().get(i).getId(),
                    contracts.getContent().get(i).getStartDay(),
                    contracts.getContent().get(i).getEndDay(),
                    contracts.getContent().get(i).getDeposit(),
                    contracts.getContent().get(i).getEmployee(),
                    contracts.getContent().get(i).getCustomer(),
                    contracts.getContent().get(i).getFacility(),
                    contracts.getContent().get(i).getContractDetailList(),
                    total);
            contractDtos.add(contractDto);
        }
        contractDtoPage = new PageImpl<>(contractDtos);
        return contractDtoPage;
    }
}
