package com.email.traning.domain.real;

import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.Order;
import com.email.traning.domain.model.User;

import java.time.LocalDate;

/**
 * Created by Smeet on 13.06.2017.
 */
public class OrderReal implements Order {

    private Long id;
    private LocalDate date;
    private LocalDate dueDate;
    private Double totalPrice;
    private Car car;
    private User user;

    public OrderReal() {

    }

    public OrderReal(LocalDate date, LocalDate dueDate, Double totalPrice, Car car, User user) {
        this.date = date;
        this.dueDate = dueDate;
        this.totalPrice = totalPrice;
        this.car = car;
        this.user = user;
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
    public LocalDate getDate() {
        return date;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
