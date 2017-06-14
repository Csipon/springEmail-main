package com.email.traning.domain.model;

/**
 * Created by Smeet on 14.06.2017.
 */
public enum Statuses {

    ENABLE(1L, "ENABLE"),
    RESERVED(2L, "RESERVED"),
    ORDERED(3L, "ORDERED"),

    NEW(4L, "NEW"),
    PROCESSING(5L, "PROCESSING"),
    ACTIVE(6L, "ACTIVE"),
    FINISHED(7L, "FINISHED"),
    REJECTED(8L, "REJECTED");

    private Long id;
    private String status;

    Statuses(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
