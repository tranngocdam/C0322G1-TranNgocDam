package com.case_study.demo.dto;

import com.case_study.demo.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Integer id;
    @Pattern(regexp = "^([A-Z][a-z]{1,})\\s([A-Z][a-z]{0,})+(\\s([A-Z][a-z]{0,}+))?$", message = "Viết hoa chữ cái đầu(vd: Nguyen Van A)")
    @NotBlank(message = "Blank is name")
    private String name;
    @NotBlank(message = "Blank is day of birth")
    private String dayOfBirth;
    @NotBlank(message = "Blank is gender")
    private String gender;
    @Pattern(regexp = "^[0-9]{9}$")
    @NotBlank(message = "Blank is card")
    private String idCard;
    @Pattern(regexp = "^(090)[0-9]{7}|(091)[0-9]{7}|((84)91)[0-9]{7}||((84)90)[0-9]{7}$", message = "Vd:090(7 chữ số 0-9),091(7 chữ số 0-9)")
    @NotBlank(message = "Blank is phone number")
    private String phoneNumber;
    @Pattern(regexp = "^([a-z 0-9]{3,})@gmail.com$")
    @NotBlank(message = "Blank is email")
    private String email;
    @NotBlank(message = "Blank is address")
    private String address;
//    @NotBlank(message = "Blank is customer type")
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String dayOfBirth, String gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    }
}
