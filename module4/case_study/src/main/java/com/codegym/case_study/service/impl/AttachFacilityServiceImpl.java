package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.AttachFacility;
import com.codegym.case_study.repository.IAttachFacilityRepository;
import com.codegym.case_study.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        iAttachFacilityRepository.save(attachFacility);
    }

    @Override
    public void delete(Integer id) {
        iAttachFacilityRepository.deleteById(id);
    }
}
