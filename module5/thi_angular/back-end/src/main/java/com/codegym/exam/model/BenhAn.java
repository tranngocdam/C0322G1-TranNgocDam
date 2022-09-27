package com.codegym.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class BenhAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String liDo;
    private String phuongPhap;
    private String bacSi;
    @ManyToOne
    @JoinColumn(name = "benh_nhan_id", referencedColumnName = "id")
    private MaBenhNhan maBenhNhan;

    @ManyToOne
    @JoinColumn(name = "benh_an_id", referencedColumnName = "id")
    private MaBenhAn maBenhAn;

    public BenhAn() {
    }

    public BenhAn(Integer id, String ngayNhapVien, String ngayRaVien, String liDo, String phuongPhap, String bacSi, MaBenhNhan maBenhNhan, MaBenhAn maBenhAn) {
        this.id = id;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.liDo = liDo;
        this.phuongPhap = phuongPhap;
        this.bacSi = bacSi;
        this.maBenhNhan = maBenhNhan;
        this.maBenhAn = maBenhAn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public String getPhuongPhap() {
        return phuongPhap;
    }

    public void setPhuongPhap(String phuongPhap) {
        this.phuongPhap = phuongPhap;
    }

    public String getBacSi() {
        return bacSi;
    }

    public void setBacSi(String bacSi) {
        this.bacSi = bacSi;
    }

    public MaBenhNhan getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(MaBenhNhan maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public MaBenhAn getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(MaBenhAn maBenhAn) {
        this.maBenhAn = maBenhAn;
    }
}
