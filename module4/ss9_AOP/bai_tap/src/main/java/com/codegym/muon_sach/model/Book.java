package com.codegym.muon_sach.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<DetailBook> detailBookList;

    public Book() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<DetailBook> getDetailBookList() {
        return detailBookList;
    }

    public void setDetailBookList(List<DetailBook> detailBookList) {
        this.detailBookList = detailBookList;
    }
}
