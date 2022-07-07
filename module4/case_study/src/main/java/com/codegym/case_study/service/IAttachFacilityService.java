package com.codegym.case_study.service;

import com.codegym.case_study.model.AttachFacility;
import com.codegym.case_study.model.Contract;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    void save(AttachFacility attachFacility);

    void delete(Integer id);
}
