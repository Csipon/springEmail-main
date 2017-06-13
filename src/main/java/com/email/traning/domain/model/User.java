package com.email.traning.domain.model;

/**
 * Created by Smeet on 06.06.2017.
 */
public interface User {

    Long getId();

    void setId(Long id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    UserRole getUserRole();

    void setUserRole(UserRole userRole);
}
