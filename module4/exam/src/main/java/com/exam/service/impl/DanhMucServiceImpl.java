package com.exam.service.impl;

import com.exam.model.DanhMuc;
import com.exam.repository.IDanhMucRepository;
import com.exam.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpl implements IDanhMucService {
    @Autowired
    private IDanhMucRepository iDanhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return iDanhMucRepository.findAll();
    }
}
