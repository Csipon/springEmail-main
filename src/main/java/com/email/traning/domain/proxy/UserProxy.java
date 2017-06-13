package com.email.traning.domain.proxy;

import com.email.traning.dao.UserDao;
import com.email.traning.domain.model.User;
import com.email.traning.domain.model.UserRole;

/**
 * Created by Smeet on 13.06.2017.
 */
public class UserProxy implements User {

    private Long id;
    private UserDao userDao;
    private User user;

    public UserProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String name) {
        getUser().setFirstName(name);
    }

    public String getFirstName() {
        return getUser().getFirstName();
    }

    public void setLastName(String lastName) {
        getUser().setLastName(lastName);
    }

    public String getLastName() {
        return getUser().getLastName();
    }

    public void setEmail(String email) {
        getUser().setEmail(email);
    }

    public String getEmail() {
        return getUser().getEmail();
    }

    public void setPassword(String password) {
        getUser().setPassword(password);
    }

    public String getPassword() {
        return getUser().getEmail();
    }

    public void setUserRole(UserRole userRole) {
        getUser().setUserRole(userRole);
    }

    public UserRole getUserRole() {
        return getUser().getUserRole();
    }

    private User getUser() {
        if(user == null) {
            user = userDao.getById(id);
        }
        return user;
    }

}
