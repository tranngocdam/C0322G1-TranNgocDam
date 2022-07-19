package com.codegym.model;

public class Declaration {
    private Integer id;
    private String name;
    private String year;
    private String travelInformation;
    private String dayStart;
    private String dayEnd;
    private String go;

    public Declaration() {
    }

    public Declaration(Integer id, String name, String year, String travelInformation, String dayStart, String dayEnd, String go) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.travelInformation = travelInformation;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.go = go;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getGo() {
        return go;
    }

    public void setGo(String go) {
        this.go = go;
    }
}
