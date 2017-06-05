package com.email.traning.model;

import java.time.LocalDate;

/**
 * Created by Pasha on 05.06.2017.
 */
public class Order {

    private Double price;
    private LocalDate dateReservation;


    public Order(Double price, LocalDate dateReservation) {
        this.price = price;
        this.dateReservation = dateReservation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }
}
