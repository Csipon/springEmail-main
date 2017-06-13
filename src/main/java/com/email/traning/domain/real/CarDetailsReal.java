package com.email.traning.domain.real;

import com.email.traning.domain.model.CarDetails;

/**
 * Created by Smeet on 13.06.2017.
 */
public class CarDetailsReal implements CarDetails {

    private Long id;
    private Integer speed;
    private String classCar;
    private String power;
    private String fuelType;
    private Integer fuelConsume;
    private String type;
    private String salon;
    private Boolean turbo;
    private Integer acceleration;

    public CarDetailsReal() {

    }

    public CarDetailsReal(Integer speed, String classCar, String power, String fuelType, Integer fuelConsume, String type, String salon, Boolean turbo, Integer acceleration) {
        this.speed = speed;
        this.classCar = classCar;
        this.power = power;
        this.fuelType = fuelType;
        this.fuelConsume = fuelConsume;
        this.type = type;
        this.salon = salon;
        this.turbo = turbo;
        this.acceleration = acceleration;
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
        return speed;
    }

    @Override
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Override
    public String getClassCar() {
        return classCar;
    }

    @Override
    public void setClassCar(String classCar) {
        this.classCar = classCar;
    }

    @Override
    public String getPower() {
        return power;
    }

    @Override
    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public Integer getFuelConsume() {
        return fuelConsume;
    }

    @Override
    public void setFuelConsume(Integer fuelConsume) {
        this.fuelConsume = fuelConsume;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getSalon() {
        return salon;
    }

    @Override
    public void setSalon(String salon) {
        this.salon = salon;
    }

    @Override
    public Boolean getTurbo() {
        return turbo;
    }

    @Override
    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }

    @Override
    public Integer getAcceleration() {
        return acceleration;
    }

    @Override
    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }
}
