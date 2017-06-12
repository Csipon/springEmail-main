package com.email.traning.domain.model;

import java.time.LocalDate;

/**
 * Created by Pasha on 05.06.2017.
 */
public class Order {

    private Long id;
    private LocalDate date;
    private LocalDate dueDate;
    private Double totalPrice;
    private Car car;
    private User user;

    public Order() {

    }

    public Order(LocalDate date, LocalDate dueDate, Double totalPrice, Car car, User user) {
        this.date = date;
        this.dueDate = dueDate;
        this.totalPrice = totalPrice;
        this.car = car;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
