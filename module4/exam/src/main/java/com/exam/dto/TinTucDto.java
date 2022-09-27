package com.exam.dto;

import com.exam.model.DanhMuc;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TinTucDto implements Validator {
    private Integer Id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String tieuDe;
    private String ngayDangTin;
    @NotBlank
    private String phongVien;
    private DanhMuc danhMuc;

    public TinTucDto() {
    }

    public TinTucDto(Integer id, @NotBlank @Size(min = 1, max = 50) String tieuDe, String ngayDangTin, @NotBlank String phongVien, @NotBlank DanhMuc danhMuc) {
        Id = id;
        this.tieuDe = tieuDe;
        this.ngayDangTin = ngayDangTin;
        this.phongVien = phongVien;
        this.danhMuc = danhMuc;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(String ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
