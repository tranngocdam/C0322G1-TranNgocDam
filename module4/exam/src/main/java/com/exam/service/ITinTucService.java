package com.exam.service;

import com.exam.model.TinTuc;

import java.util.List;

public interface ITinTucService {
    List<TinTuc> findAll();

    void save(TinTuc tinTuc);

    void delete(Integer id);

    List<TinTuc> searchTieuDe(String tieuDe);
}
