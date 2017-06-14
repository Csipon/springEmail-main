package com.email.traning.domain.model;

import java.time.LocalDate;

/**
 * Created by Smeet on 14.06.2017.
 */
public interface History {

    Long getId();

    void setId(Long id);

    LocalDate getDate();

    void setDate(LocalDate date);

    String getDescription();

    void setDescription(String description);

    Order getOrder();

    void setOrder(Order order);

    Statuses getStatus();

    void setStatus(Statuses status);
}
