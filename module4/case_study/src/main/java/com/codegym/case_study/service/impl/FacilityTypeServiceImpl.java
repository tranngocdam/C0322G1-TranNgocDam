package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.FacilityType;
import com.codegym.case_study.repository.IFacilityTypeRepository;
import com.codegym.case_study.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
