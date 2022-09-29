package com.sprint2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String percent;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;

    @JsonBackReference
    @OneToMany(mappedBy = "discount")
    private List<Book> bookList;

    public Discount() {
    }

    public Discount(Integer id, String percent, Boolean isDelete, List<Book> bookList) {
        this.id = id;
        this.percent = percent;
        this.isDelete = isDelete;
        this.bookList = bookList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
