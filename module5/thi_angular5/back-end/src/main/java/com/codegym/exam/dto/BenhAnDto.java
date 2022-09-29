package com.codegym.exam.dto;
import com.codegym.exam.model.MaBenhAn;
import com.codegym.exam.model.MaBenhNhan;

import javax.validation.constraints.NotBlank;

public class BenhAnDto {
    private Integer id;
    @NotBlank
    private String ngayNhapVien;
    @NotBlank
    private String ngayRaVien;
    @NotBlank
    private String liDo;
    @NotBlank
    private String phuongPhap;
    @NotBlank
    private String bacSi;
    @NotBlank
    private MaBenhNhan maBenhNhan;
    @NotBlank
    private MaBenhAn maBenhAn;

    public BenhAnDto() {
    }

    public BenhAnDto(Integer id, String ngayNhapVien, String ngayRaVien, String liDo, String phuongPhap, String bacSi, MaBenhNhan maBenhNhan, MaBenhAn maBenhAn) {
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
