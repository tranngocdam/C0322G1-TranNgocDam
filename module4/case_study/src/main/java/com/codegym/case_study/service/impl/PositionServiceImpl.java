package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.Position;
import com.codegym.case_study.repository.IPositionRepository;
import com.codegym.case_study.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
