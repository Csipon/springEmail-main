package com.email.traning.domain.proxy;

import com.email.traning.dao.CarDetailsDao;
import com.email.traning.domain.model.CarDetails;

/**
 * Created by Smeet on 13.06.2017.
 */
public class CarDetailsProxy implements CarDetails {

    private Long id;
    private CarDetailsDao carDetailsDao;
    private CarDetails carDetails;

    public CarDetailsProxy(CarDetailsDao carDetailsDao) {
        this.carDetailsDao = carDetailsDao;
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
    public Integer getSpeed() {
        return getCarDetails().getSpeed();
    }

    @Override
    public void setSpeed(Integer speed) {
        getCarDetails().setSpeed(speed);
    }

    @Override
    public String getClassCar() {
        return getCarDetails().getClassCar();
    }

    @Override
    public void setClassCar(String classCar) {
        getCarDetails().setClassCar(classCar);
    }

    @Override
    public String getPower() {
        return getCarDetails().getPower();
    }

    @Override
    public void setPower(String power) {
        getCarDetails().setPower(power);
    }

    @Override
    public String getFuelType() {
        return getCarDetails().getFuelType();
    }

    @Override
    public void setFuelType(String fuelType) {
        getCarDetails().setFuelType(fuelType);
    }

    @Override
    public Integer getFuelConsume() {
        return getCarDetails().getFuelConsume();
    }

    @Override
    public void setFuelConsume(Integer fuelConsume) {
        getCarDetails().setFuelConsume(fuelConsume);
    }

    @Override
    public String getType() {
        return getCarDetails().getType();
    }

    @Override
    public void setType(String type) {
        getCarDetails().setType(type);
    }

    @Override
    public String getSalon() {
        return getCarDetails().getSalon();
    }

    @Override
    public void setSalon(String salon) {
        getCarDetails().setSalon(salon);
    }

    @Override
    public Boolean getTurbo() {
        return getCarDetails().getTurbo();
    }

    @Override
    public void setTurbo(Boolean turbo) {
        getCarDetails().setTurbo(turbo);
    }

    @Override
    public Integer getAcceleration() {
        return getCarDetails().getAcceleration();
    }

    @Override
    public void setAcceleration(Integer acceleration) {
        getCarDetails().setAcceleration(acceleration);
    }

    public CarDetails getCarDetails() {
        if(carDetails == null) {
            carDetails = carDetailsDao.getById(id);
        }
        return carDetails;
    }
}
