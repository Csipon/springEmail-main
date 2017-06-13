package com.email.traning.dao;

import com.email.traning.domain.model.User;
import com.email.traning.domain.model.UserRole;
import com.email.traning.domain.real.UserReal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    private Long idUser;
    private User user;

    @Before
    public void creteUser() {
        user = new UserReal("Andrii", "Smetanko", "Andryuha@gmail.com", "123123", UserRole.ROLE_USER);
        userDao.create(user);
        idUser = user.getId();
        assertNotNull("User id is null", idUser);
        System.out.println("User with id " + idUser + " added");
    }

    @After
    public void cleanUser(){
        assertNotNull("User with id -> " + idUser + " not deleted" , userDao.remove(idUser));
        System.out.println("After");
    }

    @Test
    public void checkCreatedUser() {
        User user = userDao.getById(idUser);
        assertNotNull("User object from db is null", user);
        System.out.println("Method");
    }

    @Test
    public void update() {
        user.setFirstName("Andrio");
        assertNotNull("User not updated", userDao.update(user));
        System.out.println("User updated");
    }

}