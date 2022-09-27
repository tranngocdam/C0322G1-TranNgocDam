package com.codegym.exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class MaBenhAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "maBenhAn")
    private List<BenhAn> benhAnList;

    public MaBenhAn() {
    }

    public MaBenhAn(Integer id, String name, List<BenhAn> benhAnList) {
        this.id = id;
        this.name = name;
        this.benhAnList = benhAnList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BenhAn> getBenhAnList() {
        return benhAnList;
    }

    public void setBenhAnList(List<BenhAn> benhAnList) {
        this.benhAnList = benhAnList;
    }
}
