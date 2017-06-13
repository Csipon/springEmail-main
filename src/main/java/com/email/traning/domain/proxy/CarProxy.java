package com.email.traning.domain.proxy;

import com.email.traning.dao.CarDao;
import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.CarDetails;

/**
 * Created by Smeet on 13.06.2017.
 */
public class CarProxy implements Car{

    private Long id;
    private CarDao carDao;
    private Car car;

    public CarProxy(CarDao carDao) {
        this.carDao = carDao;
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
        return getCar().getModel();
    }

    @Override
    public void setModel(String model) {
        getCar().setModel(model);
    }

    @Override
    public String getMark() {
        return getCar().getMark();
    }

    @Override
    public void setMark(String mark) {
        getCar().setMark(mark);
    }

    @Override
    public Integer getYear() {
        return getCar().getYear();
    }

    @Override
    public void setYear(Integer year) {
        getCar().setYear(year);
    }

    @Override
    public Double getPricePerHour() {
        return getCar().getPricePerHour();
    }

    @Override
    public void setPricePerHour(Double pricePerHour) {
        getCar().setPricePerHour(pricePerHour);
    }

    @Override
    public CarDetails getCarDetails() {
        return getCar().getCarDetails();
    }

    @Override
    public void setCarDetails(CarDetails carDetails) {
        getCar().setCarDetails(carDetails);
    }

    private Car getCar() {
        if(car == null) {
            car = carDao.getById(id);
        }
        return car;
    }
}
