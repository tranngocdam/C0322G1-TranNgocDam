package com.codegym.case_study.dto;

import com.codegym.case_study.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

public class CustomerDto implements Validator {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String dayOfBirth;
    @NotBlank
    private Integer gender;
    @NotBlank
    private String idCard;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String dayOfBirth, Integer gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto=(CustomerDto) target;
        String name=customerDto.getName();
        if (!name.matches("^\\w{5,45}$")){
            errors.rejectValue("name", "name.rejected", "Kí tự đầu tiên của mỗi từ phải viết hoa");
        }

        String phoneNumber=customerDto.getPhoneNumber();
        if(!phoneNumber.matches("^090[0-9]{7}|091[0-9]{7}$")){
            errors.rejectValue("phoneNumber", "phoneNumber.rejected", "đúng định dạng 090xxxxxxx hoặc 091xxxxxxx");
        }
        String email=customerDto.getEmail();
        if(!email.matches("^([a-z 0-9]{1,})@gmail.com$")){
            errors.rejectValue("email", "email.rejected", "đúng định dạng email(vd:an12@gmail.com)");
        }
    }
}
