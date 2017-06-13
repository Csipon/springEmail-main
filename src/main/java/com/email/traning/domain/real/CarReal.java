package com.email.traning.domain.real;

import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.CarDetails;

/**
 * Created by Smeet on 13.06.2017.
 */
public class CarReal implements Car {

    private Long id;
    private String model;
    private String mark;
    private Integer year;
    private Double pricePerHour;
    private CarDetails carDetails;

    public CarReal() {

    }

    public CarReal(String model, String mark, Integer year, Double pricePerHour, CarDetails carDetails) {
        this.model = model;
        this.mark = mark;
        this.year = year;
        this.pricePerHour = pricePerHour;
        this.carDetails = carDetails;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    @Override
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public Double getPricePerHour() {
        return pricePerHour;
    }

    @Override
    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public CarDetails getCarDetails() {
        return carDetails;
    }

    @Override
    public void setCarDetails(CarDetails carDetails) {
        this.carDetails = carDetails;
    }
}
