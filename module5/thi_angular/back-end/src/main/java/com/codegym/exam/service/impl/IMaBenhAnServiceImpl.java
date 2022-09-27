package com.codegym.exam.service.impl;

import com.codegym.exam.model.MaBenhAn;
import com.codegym.exam.repository.IMaBenhAnRepository;
import com.codegym.exam.service.MaBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMaBenhAnServiceImpl implements MaBenhAnService {
    @Autowired
    private IMaBenhAnRepository iMaBenhAnRepository;
    @Override
    public List<MaBenhAn> findAll() {
        return iMaBenhAnRepository.findAllMaBenhAn();
    }
}
