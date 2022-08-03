package com.case_study.demo.service.impl;

import com.case_study.demo.model.Facility;
import com.case_study.demo.repository.IFacilityRepository;
import com.case_study.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAllFacility(pageable);
    }

    @Override
    public Facility save(Facility facility) {
        return iFacilityRepository.save(facility);
    }
}
