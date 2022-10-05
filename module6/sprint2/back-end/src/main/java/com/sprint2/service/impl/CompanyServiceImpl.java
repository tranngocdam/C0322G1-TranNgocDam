package com.sprint2.service.impl;

import com.sprint2.repository.ICompanyRepository;
import com.sprint2.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private ICompanyRepository iCompanyRepository;
}
