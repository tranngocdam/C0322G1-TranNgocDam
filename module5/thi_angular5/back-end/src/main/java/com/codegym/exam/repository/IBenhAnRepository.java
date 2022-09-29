package com.codegym.exam.repository;

import com.codegym.exam.model.BenhAn;
import com.codegym.exam.model.MaBenhAn;
import com.codegym.exam.model.MaBenhNhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBenhAnRepository extends JpaRepository<BenhAn, Integer> {
    @Query(value = "select * from benh_an", nativeQuery = true)
    Page<BenhAn> findAllBenhAn(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "insert into benh_an(bac_si, li_do, ngay_nhap_vien, ngay_ra_vien, phuong_phap, benh_nhan_id, benh_an_id)" +
            "value (:bacSi, :liDo, :ngayNhapVien, :ngayRaVien, :phuongPhap, :maBenhNhan, :maBenhAn)", nativeQuery = true)
    void saveBenhAn(@Param("bacSi") String bacSi,
                    @Param("liDo") String liDo,
                    @Param("ngayNhapVien") String ngayNhapVien,
                    @Param("ngayRaVien") String ngayRaVien,
                    @Param("phuongPhap") String phuongPhap,
                    @Param("maBenhNhan")MaBenhNhan maBenhNhan,
                    @Param("maBenhAn")MaBenhAn maBenhAn);

    @Query(value = "select * from benh_an ba where ba.id =:id", nativeQuery = true)
    BenhAn findByIdBenhAn(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from benh_an c where c.id =:id", nativeQuery = true)
    void deleteBenhAn(@Param("id") Integer id);

    @Query(value = "select * from benh_an where li_do like :li_do", nativeQuery = true)
    Page<BenhAn> findBenhAnByLiDo(@Param("liDo") String liDo, Pageable pageable);
}
