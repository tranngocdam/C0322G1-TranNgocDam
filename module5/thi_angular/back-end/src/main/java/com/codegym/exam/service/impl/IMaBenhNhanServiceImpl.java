package com.codegym.exam.service.impl;

import com.codegym.exam.model.MaBenhNhan;
import com.codegym.exam.repository.IMaBenhNhanRepository;
import com.codegym.exam.service.MaBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMaBenhNhanServiceImpl implements MaBenhNhanService {
    @Autowired
    private IMaBenhNhanRepository iMaBenhNhanRepository;
    @Override
    public List<MaBenhNhan> findAll() {
        return iMaBenhNhanRepository.findAllMaBenhNhan();
    }
}
