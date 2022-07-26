package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = " select * from Book", nativeQuery = true)
    Page<Book> findAll(Pageable pageable);
}
