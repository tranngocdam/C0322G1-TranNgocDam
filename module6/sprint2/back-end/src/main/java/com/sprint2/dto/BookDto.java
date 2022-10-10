package com.sprint2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sprint2.model.Category;
import com.sprint2.model.Company;
import com.sprint2.model.Discount;
import com.sprint2.model.OrderBook;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class BookDto {
    private Integer id;
    private String name;
    private String code;
    private LocalDate createDate;
    private String size;
    private String description;
    private String author;
    private Double price;
    private Integer amount;
    private String image;
    private Integer numberOfPage;
    private Boolean status;
    private Category category;
    private Company company;
    private Discount discount;
    private List<OrderBook> orderBookList;

    public BookDto() {
    }

    public BookDto(Integer id, String name, String code, LocalDate createDate, String size, String description, String author, Double price, Integer amount, String image, Integer numberOfPage, Boolean status, Category category, Company company, Discount discount, List<OrderBook> orderBookList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.createDate = createDate;
        this.size = size;
        this.description = description;
        this.author = author;
        this.price = price;
        this.amount = amount;
        this.image = image;
        this.numberOfPage = numberOfPage;
        this.status = status;
        this.category = category;
        this.company = company;
        this.discount = discount;
        this.orderBookList = orderBookList;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Integer numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<OrderBook> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(List<OrderBook> orderBookList) {
        this.orderBookList = orderBookList;
    }
}
