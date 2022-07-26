package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.DetailBook;

import java.util.List;
import java.util.Optional;

public interface IDetailBookService {
    List<DetailBook> findAll();

    void save(DetailBook detailBook);

    Optional<DetailBook> findByCode(Long code);

    void deleteByCode(Long code);

    void deleteById(Integer id);
}
