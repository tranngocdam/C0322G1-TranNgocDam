package com.sprint2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String percent;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

//    @JsonBackReference
@JsonIgnore
    @OneToMany(mappedBy = "discount")
    private List<Book> bookList;

    public Discount() {
    }

    public Discount(Integer id, String percent, Boolean status, List<Book> bookList) {
        this.id = id;
        this.percent = percent;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
