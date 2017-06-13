package com.email.traning.domain.proxy;

import com.email.traning.dao.OrderDao;
import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.Order;
import com.email.traning.domain.model.User;

import java.time.LocalDate;

/**
 * Created by Smeet on 13.06.2017.
 */
public class OrderProxy implements Order {

    private Long id;
    private OrderDao orderDao;
    private Order order;


    public OrderProxy(OrderDao orderDao) {
        this.orderDao = orderDao;
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
        return getOrder().getDate();
    }

    @Override
    public void setDate(LocalDate date) {
        getOrder().setDate(date);
    }

    @Override
    public LocalDate getDueDate() {
        return getOrder().getDueDate();
    }

    @Override
    public void setDueDate(LocalDate dueDate) {
        getOrder().setDueDate(dueDate);
    }

    @Override
    public Double getTotalPrice() {
        return getOrder().getTotalPrice();
    }

    @Override
    public void setTotalPrice(Double totalPrice) {
        getOrder().setTotalPrice(totalPrice);
    }

    @Override
    public Car getCar() {
        return getOrder().getCar();
    }

    @Override
    public void setCar(Car car) {
        getOrder().setCar(car);
    }

    @Override
    public User getUser() {
        return getOrder().getUser();
    }

    @Override
    public void setUser(User user) {
        getOrder().setUser(user);
    }

    private Order getOrder() {
        if(order == null) {
            order = orderDao.getById(id);
        }
        return order;
    }
}
