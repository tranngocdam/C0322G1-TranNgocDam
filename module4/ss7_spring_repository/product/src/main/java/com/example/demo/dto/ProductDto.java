package com.example.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProductDto implements Validator {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^(\\w\\s?){0,29}\\w$")
    private String name;
    @NotBlank
    @Pattern(regexp = "^[0-9]{4,}$")
    private String price;
    @NotBlank
    @Pattern(regexp = "^(\\w\\s?){0,99}\\w$")
    private String producer;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, String price, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
