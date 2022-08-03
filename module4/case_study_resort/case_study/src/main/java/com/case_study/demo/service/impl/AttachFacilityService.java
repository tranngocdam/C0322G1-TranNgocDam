package com.case_study.demo.service.impl;

import com.case_study.demo.model.AttachFacility;
import com.case_study.demo.repository.IAttachFacilityRepository;
import com.case_study.demo.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
