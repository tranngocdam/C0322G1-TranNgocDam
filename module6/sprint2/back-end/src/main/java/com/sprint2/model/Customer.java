package com.sprint2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate dayOfBirth;
    private String address;
    private Boolean gender;
    private String phone;
    private String email;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonBackReference
    @JsonIgnore
    private AppUsers appUsers;

//    @JsonBackReference
@JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<OrderBook> orderBookList;

//    @JsonBackReference
@JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<FeedBack> feedBackList;

    public Customer() {
    }

    public Customer(Integer id, String name, LocalDate dayOfBirth, String address, Boolean gender, String phone, String email, Boolean status, AppUsers appUsers, List<OrderBook> orderBookList, List<FeedBack> feedBackList) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.appUsers = appUsers;
        this.orderBookList = orderBookList;
        this.feedBackList = feedBackList;
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

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }

    public List<OrderBook> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(List<OrderBook> orderBookList) {
        this.orderBookList = orderBookList;
    }

    public List<FeedBack> getFeedBackList() {
        return feedBackList;
    }

    public void setFeedBackList(List<FeedBack> feedBackList) {
        this.feedBackList = feedBackList;
    }
}
