package com.email.traning.domain.real;

import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.Order;
import com.email.traning.domain.model.Statuses;
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
    private Statuses statuses;
    private Car car;
    private User customer;
    private User manager;

    public OrderReal() {

    }

    public OrderReal(LocalDate date, LocalDate dueDate, Double totalPrice, Statuses statuses, Car car, User customer, User manager) {
        this.date = date;
        this.dueDate = dueDate;
        this.totalPrice = totalPrice;
        this.statuses = statuses;
        this.car = car;
        this.customer = customer;
        this.manager = manager;
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
    public User getManager() {
        return manager;
    }

    @Override
    public void setManager(User manager) {
        this.manager = manager;
    }

    @Override
    public User getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    @Override
    public Statuses getStatus() {
        return statuses;
    }

    @Override
    public void setStatus(Statuses status) {
        this.statuses = status;
    }

}
