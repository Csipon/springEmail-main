package com.email.traning.domain.model;

/**
 * Created by Pasha on 05.06.2017.
 */
public interface Car {

    Long getId();

    void setId(Long id);

    String getModel();

    void setModel(String model);

    String getMark();

    void setMark(String mark);

    Integer getYear();

    void setYear(Integer year);

    Double getPricePerHour();

    void setPricePerHour(Double pricePerHour);

    CarDetails getCarDetails();

    void setCarDetails(CarDetails carDetails);

    Statuses getStatus();

    void setStatus(Statuses status);
}
