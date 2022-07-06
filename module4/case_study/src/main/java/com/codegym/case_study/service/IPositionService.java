package com.codegym.case_study.service;

import com.codegym.case_study.model.Position;
import com.codegym.case_study.model.RentType;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
