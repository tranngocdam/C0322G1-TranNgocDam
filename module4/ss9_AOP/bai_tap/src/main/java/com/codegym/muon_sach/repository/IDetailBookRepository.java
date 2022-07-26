package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.DetailBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IDetailBookRepository extends JpaRepository<DetailBook, Integer> {
    @Query(value="select * from DetailBook d where d.code=:code",nativeQuery=true)
    Optional<DetailBook> findByCode(@Param("code") Long code);

    @Transactional
    @Modifying
    @Query(value = "delete from DetailBook d where d.code=:code", nativeQuery=true)
    void deleteByCode(@Param("code") Long code);
}
