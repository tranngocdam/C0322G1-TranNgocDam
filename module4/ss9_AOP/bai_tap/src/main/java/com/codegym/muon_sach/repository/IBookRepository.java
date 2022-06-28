package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = " select * from Book", nativeQuery = true)
    Page<Book> findAll(Pageable pageable);
}
