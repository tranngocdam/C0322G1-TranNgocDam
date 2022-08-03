package com.case_study.demo.service.impl;

import com.case_study.demo.model.Position;
import com.case_study.demo.repository.IPositionRepository;
import com.case_study.demo.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
