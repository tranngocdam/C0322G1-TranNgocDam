package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.DetailBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDetailBookRepository extends JpaRepository<DetailBook, Long> {
    Optional<DetailBook> findByCode(Long code);

    void deleteByCode(Long code);
}
