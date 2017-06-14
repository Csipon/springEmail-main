package com.email.traning.domain.proxy;

import com.email.traning.dao.HistoryDao;
import com.email.traning.domain.model.History;
import com.email.traning.domain.model.Order;
import com.email.traning.domain.model.Statuses;

import java.time.LocalDate;

/**
 * Created by Smeet on 14.06.2017.
 */
public class HistoryProxy implements History {

    private Long id;
    private History history;
    private HistoryDao historyDao;

    public HistoryProxy(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    private History getHistory() {
        if(history == null) {
            historyDao.getById(id);
        }
        return history;
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
        return getHistory().getDate();
    }

    @Override
    public void setDate(LocalDate date) {
        getHistory().setDate(date);
    }

    @Override
    public String getDescription() {
        return getHistory().getDescription();
    }

    @Override
    public void setDescription(String description) {
        getHistory().setDescription(description);
    }

    @Override
    public Order getOrder() {
        return getHistory().getOrder();
    }

    @Override
    public void setOrder(Order order) {
        getHistory().setOrder(order);
    }

    @Override
    public Statuses getStatus() {
        return getHistory().getStatus();
    }

    @Override
    public void setStatus(Statuses status) {
        getHistory().setStatus(status);
    }
}
