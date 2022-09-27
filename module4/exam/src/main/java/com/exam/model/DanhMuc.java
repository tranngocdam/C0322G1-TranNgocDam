package com.exam.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String tenDanhMuc;
    @OneToMany(mappedBy = "danhMuc")
    private List<TinTuc> tinTucs;

    public DanhMuc() {
    }

    public DanhMuc(Integer id, String tenDanhMuc, List<TinTuc> tinTucs) {
        Id = id;
        this.tenDanhMuc = tenDanhMuc;
        this.tinTucs = tinTucs;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public List<TinTuc> getTinTucs() {
        return tinTucs;
    }

    public void setTinTucs(List<TinTuc> tinTucs) {
        this.tinTucs = tinTucs;
    }
}
