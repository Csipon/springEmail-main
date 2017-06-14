package com.email.traning.domain.real;

import com.email.traning.domain.model.History;
import com.email.traning.domain.model.Order;
import com.email.traning.domain.model.Statuses;

import java.time.LocalDate;

/**
 * Created by Smeet on 14.06.2017.
 */
public class HistoryReal implements History {

    private Long id;
    private LocalDate date;
    private String description;
    private Order order;
    private Statuses statuses;

    public HistoryReal() {

    }

    public HistoryReal(LocalDate date, String description, Order order, Statuses statuses) {
        this.date = date;
        this.description = description;
        this.order = order;
        this.statuses = statuses;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }

    public Statuses getStatus() {
        return statuses;
    }

    public void setStatus(Statuses statuses) {
        this.statuses = statuses;
    }
}
