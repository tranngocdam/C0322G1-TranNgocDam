package com.codegym.exam.repository;

import com.codegym.exam.model.MaBenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMaBenhNhanRepository extends JpaRepository<MaBenhNhan, Integer> {
    @Query(value="select * from ma_benh_nhan", nativeQuery=true)
    List<MaBenhNhan> findAllMaBenhNhan();
}
