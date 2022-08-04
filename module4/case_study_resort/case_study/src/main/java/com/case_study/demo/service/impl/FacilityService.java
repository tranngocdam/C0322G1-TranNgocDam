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
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findNameFacility(String name, Pageable pageable) {
        return iFacilityRepository.findFacility("%"+name+"%", pageable);
    }
}
