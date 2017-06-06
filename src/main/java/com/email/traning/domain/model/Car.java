package com.email.traning.domain.model;

/**
 * Created by Pasha on 05.06.2017.
 */
public class Car {

    private Long id;
    private String model;
    private String mark;
    private Integer year;
    private Double pricePerHour;
    private CarParams carParams;

    public Car(String model, String mark, Integer year, Double pricePerHour, CarParams carParams) {
        this.model = model;
        this.mark = mark;
        this.year = year;
        this.pricePerHour = pricePerHour;
        this.carParams = carParams;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public CarParams getCarParams() {
        return carParams;
    }

    public void setCarParams(CarParams carParams) {
        this.carParams = carParams;
    }
}
