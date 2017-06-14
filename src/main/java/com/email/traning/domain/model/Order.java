package com.email.traning.domain.model;

import java.time.LocalDate;

/**
 * Created by Pasha on 05.06.2017.
 */
public interface Order {

    Long getId();

    void setId(Long id);

    LocalDate getDate();

    void setDate(LocalDate date);

    LocalDate getDueDate();

    void setDueDate(LocalDate dueDate);

    Double getTotalPrice();

    void setTotalPrice(Double totalPrice);

    Car getCar();

    void setCar(Car car);

    User getManager();

    void setManager(User manager);

    User getCustomer();

    void setCustomer(User customer);

    Statuses getStatus();

    void setStatus(Statuses status);
}
