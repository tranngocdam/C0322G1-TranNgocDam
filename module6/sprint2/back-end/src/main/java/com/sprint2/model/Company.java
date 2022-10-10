package com.sprint2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

//    @JsonBackReference
@JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Book> bookList;

    public Company() {
    }

    public Company(Integer id, String name, String address, Boolean status, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.bookList = bookList;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
