package com.email.traning.domain.model;

/**
 * Created by Smeet on 06.06.2017.
 */
public enum UserRole {

    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER");

    private Integer id;
    private String role;

    UserRole(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
