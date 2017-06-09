package com.email.traning.dao;

import com.email.traning.domain.model.User;
import com.email.traning.domain.model.UserRole;
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

    @Before
    public void creteUser() {
        User user = new User("Andrii", "Smetanko", "Andryuha@gmail.com", "123123", UserRole.ROLE_USER);
        userDao.create(user);
        idUser = user.getId();
        assertNotNull("user id is null" ,idUser);
        System.out.println("before");
    }

    @After
    public void cleanUser(){
        assertNotNull("user with id -> " + idUser + " not deleted" , userDao.remove(idUser));
        System.out.println("after");
    }

    @Test
    public void checkCreatedUser() {
        User user = userDao.getById(idUser);
        assertNotNull("user object from db is null", user);
        System.out.println("method");
    }

    @Test
    public void checkUpdateUser() {
        User user = userDao.getById(idUser);
        user.setFirstName("Andrio");
        userDao.update(user);
        System.out.println(user.getFirstName());
        assertNotNull("user object from db is null", user);
    }

}