package com.codegym.muon_sach.service.impl;

import com.codegym.muon_sach.model.DetailBook;
import com.codegym.muon_sach.repository.IBookRepository;
import com.codegym.muon_sach.repository.IDetailBookRepository;
import com.codegym.muon_sach.service.IDetailBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailBookService implements IDetailBookService {
    @Autowired
    private IDetailBookRepository iDetailBookRepository;
    @Override
    public List<DetailBook> findAll() {
        return iDetailBookRepository.findAll();
    }

    @Override
    public void save(DetailBook detailBook) {
        iDetailBookRepository.save(detailBook);
    }

    @Override
    public Optional<DetailBook> findByCode(Long code) {
        return iDetailBookRepository.findByCode(code);
    }

    @Override
    public void deleteByCode(Long code) {
        iDetailBookRepository.deleteByCode(code);
    }

    @Override
    public void deleteById(Integer id) {
        iDetailBookRepository.deleteById(id);
    }
}
