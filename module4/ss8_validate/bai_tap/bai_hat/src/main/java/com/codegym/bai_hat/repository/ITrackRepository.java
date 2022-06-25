package com.codegym.bai_hat.repository;

import com.codegym.bai_hat.model.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepository extends JpaRepository<Track, Integer> {
    Page<Track> findAllByNameContaining (String keyword, Pageable pageable);
}
