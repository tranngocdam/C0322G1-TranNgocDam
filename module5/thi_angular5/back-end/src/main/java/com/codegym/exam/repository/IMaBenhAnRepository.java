package com.codegym.exam.repository;

import com.codegym.exam.model.MaBenhAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMaBenhAnRepository extends JpaRepository<MaBenhAn, Integer> {
    @Query(value = "select * from ma_benh_an", nativeQuery = true)
    List<MaBenhAn> findAllMaBenhAn();
}
