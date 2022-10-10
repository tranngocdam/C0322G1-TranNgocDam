package com.sprint2.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private LocalDate dateFeedBack;
    @Column(columnDefinition = "text")
    private String text;
    @Column(columnDefinition = "text")
    private String image;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "feedBack_id", referencedColumnName = "id")
    private Customer customer;

    public FeedBack() {
    }

    public FeedBack(Integer id, String content, LocalDate dateFeedBack, String text, String image, Boolean status, Customer customer) {
        this.id = id;
        this.content = content;
        this.dateFeedBack = dateFeedBack;
        this.text = text;
        this.image = image;
        this.status = status;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateFeedBack() {
        return dateFeedBack;
    }

    public void setDateFeedBack(LocalDate dateFeedBack) {
        this.dateFeedBack = dateFeedBack;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
