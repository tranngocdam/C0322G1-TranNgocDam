package com.codegym.exam.service;

import com.codegym.exam.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BenhAnService {
    Page<BenhAn> findAll(Pageable pageable);

    void save(BenhAn benhAn);

    BenhAn findByBenhAn(Integer id);

    void deleteBenhAn(Integer id);

    BenhAn editBenhAn(BenhAn benhAn);

    Page<BenhAn> findBenhAnByLiDo(String liDo, Pageable pageable);
}
