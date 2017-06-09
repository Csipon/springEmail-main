package com.email.traning.domain.model;

/**
 * Created by Smeet on 06.06.2017.
 */
public class CarDetails {

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

    public CarDetails(Integer speed, String classCar, String power, String fuelType, Integer fuelConsume, String type, String salon, Boolean turbo, Integer acceleration) {
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

    public CarDetails() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getClassCar() {
        return classCar;
    }

    public void setClassCar(String classCar) {
        this.classCar = classCar;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getFuelConsume() {
        return fuelConsume;
    }

    public void setFuelConsume(Integer fuelConsume) {
        this.fuelConsume = fuelConsume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public Boolean getTurbo() {
        return turbo;
    }

    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }

    public Integer getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Integer acceleration) {
        this.acceleration = acceleration;
    }
}
