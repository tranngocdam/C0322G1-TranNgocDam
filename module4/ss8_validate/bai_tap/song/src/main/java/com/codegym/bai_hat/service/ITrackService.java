package com.codegym.bai_hat.service;

import com.codegym.bai_hat.model.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITrackService {
    Page<Track> findAll(Pageable pageable);

    Track findById(Integer id);

    void save(Track track);

    Page<Track> findByNameContaining(String keyword,Pageable pageable);
}
