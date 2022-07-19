package com.codegym.case_study.dto;

import com.codegym.case_study.model.FacilityType;
import com.codegym.case_study.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class FacilityDto implements Validator {
    private Integer id;
    @NotBlank(message = "name is blank")
    private String name;
    @NotBlank
    private String area;
    @NotBlank
    private String cost;
    private Integer maxPeople;
    @NotBlank(message = "standardRoom is blank")
    private String standardRoom;
    @NotBlank(message = "descriptionOtherConvenience is blank")
    private String descriptionOtherConvenience;
    private Double poolArea;
    @NotBlank
    private String numberOfFloors;
    @NotBlank(message = "facilityFree is blank")
    private String facilityFree;

    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, String area, String cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, String numberOfFloors, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto=(FacilityDto) target;
        String name=facilityDto.getName();
        if (!name.matches("^\\w{5,45}$")){
            errors.rejectValue("name", "name.rejected", "Kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        String area=facilityDto.getArea();
        if (!area.matches("^[0-9]{1,}+(.[0-9]{1,})?$")){
            errors.rejectValue("area", "area.rejected", "Phải là số dương");
        }
        String cost=facilityDto.getCost();
        if (!cost.matches("^[0-9]{1,}+(.[0-9]{1,})?$")){
            errors.rejectValue("cost", "cost.rejected", "Phải là số dương");
        }
        String numberOfFloors=facilityDto.getNumberOfFloors();
        if (!numberOfFloors.matches("^[0-9]{1,}+(.[0-9]{1,})?$")){
            errors.rejectValue("numberOfFloors", "numberOfFloors.rejected", "Phải là số dương");
        }
    }
}
