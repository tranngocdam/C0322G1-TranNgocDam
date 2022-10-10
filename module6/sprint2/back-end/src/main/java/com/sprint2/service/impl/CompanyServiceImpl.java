package com.sprint2.service.impl;

import com.sprint2.model.Company;
import com.sprint2.repository.ICompanyRepository;
import com.sprint2.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private ICompanyRepository iCompanyRepository;

    @Override
    public List<Company> findAllCompany() {
        return iCompanyRepository.findAllCompany();
    }

    @Override
    public Company findById(Integer id) {
        return iCompanyRepository.findByIdCompany(id);
    }
}
