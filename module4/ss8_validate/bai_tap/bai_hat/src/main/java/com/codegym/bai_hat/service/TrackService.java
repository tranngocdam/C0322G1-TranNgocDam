package com.codegym.bai_hat.service;

import com.codegym.bai_hat.model.Track;
import com.codegym.bai_hat.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrackService implements ITrackService{
    @Autowired
    private ITrackRepository iTrackRepository;
    @Override
    public Page<Track> findAll(Pageable pageable) {
        return iTrackRepository.findAll(pageable);
    }

    @Override
    public Track findById(Integer id) {
        return iTrackRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Track track) {
        iTrackRepository.save(track);
    }

    @Override
    public Page<Track> findByNameContaining(String keyword, Pageable pageable) {
        return iTrackRepository.findAllByNameContaining(keyword, pageable);
    }
}
