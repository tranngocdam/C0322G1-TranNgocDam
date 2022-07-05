package com.codegym.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "position")
    private List<Employee> emoloyeeList;

    public Position() {
    }

    public Position(Integer id, String name, List<Employee> emoloyeeList) {
        this.id = id;
        this.name = name;
        this.emoloyeeList = emoloyeeList;
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

    public List<Employee> getEmoloyeeList() {
        return emoloyeeList;
    }

    public void setEmoloyeeList(List<Employee> emoloyeeList) {
        this.emoloyeeList = emoloyeeList;
    }
}
