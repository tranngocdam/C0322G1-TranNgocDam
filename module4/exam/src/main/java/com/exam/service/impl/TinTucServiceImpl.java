package com.exam.service.impl;

import com.exam.model.TinTuc;
import com.exam.repository.ITinTucRepository;
import com.exam.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinTucServiceImpl implements ITinTucService {
    @Autowired
    private ITinTucRepository iTinTucRepository;

    @Override
    public List<TinTuc> findAll() {
        return iTinTucRepository.findAll();
    }

    @Override
    public void save(TinTuc tinTuc) {
        iTinTucRepository.save(tinTuc);
    }

    @Override
    public void delete(Integer id) {
        iTinTucRepository.deleteById(id);
    }

    @Override
    public List<TinTuc> searchTieuDe(String tieuDe) {
        return iTinTucRepository.findByTieuDe(tieuDe);
    }

}
