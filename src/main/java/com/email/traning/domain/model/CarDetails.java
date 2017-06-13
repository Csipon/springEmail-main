package com.email.traning.domain.model;

/**
 * Created by Smeet on 06.06.2017.
 */
public interface CarDetails {

    Long getId();

    void setId(Long id);

    Integer getSpeed();

    void setSpeed(Integer speed);

    String getClassCar();

    void setClassCar(String classCar);

    String getPower();

    void setPower(String power);

    String getFuelType();

    void setFuelType(String fuelType);

    Integer getFuelConsume();

    void setFuelConsume(Integer fuelConsume);

    String getType();

    void setType(String type);

    String getSalon();

    void setSalon(String salon);

    Boolean getTurbo();

    void setTurbo(Boolean turbo);

    Integer getAcceleration();

    void setAcceleration(Integer acceleration);
}
