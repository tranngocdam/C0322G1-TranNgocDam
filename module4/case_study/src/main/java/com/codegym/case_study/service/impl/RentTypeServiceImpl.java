package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.RentType;
import com.codegym.case_study.repository.IRentTypeRepository;
import com.codegym.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
