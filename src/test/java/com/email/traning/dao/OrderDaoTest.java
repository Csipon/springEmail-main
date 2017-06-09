package com.email.traning.dao;

import com.email.traning.domain.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Smeet on 09.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;
    @Autowired
    CarDao carDao;
    @Autowired
    UserDao userDao;
    Long orderId;

    @Before
    public void createOrder() {
        User user = new User("Andrii", "Smetanko", "Andryuha@gmail.com", "123123", UserRole.ROLE_USER);
        userDao.create(user);
        Car car = new Car("Z-1", "Audi", 2006, 400D, new CarDetails());
        carDao.create(car);

        Order order = new Order(LocalDate.now(), LocalDate.now(), 500D, car, user);
        orderDao.create(order);
        orderId = order.getId();
        assertNotNull("Order id is null", orderId);
        System.out.println("Order with id " + orderId + " added");
    }

    @After
    public void removeOrder() {
        assertNotNull("Order not deleted", orderDao.remove(orderId));
        System.out.println("Removed");

    }

    @Test
    public void checkGetOrder() {
        Order order = orderDao.getById(orderId);
        assertNotNull("Object from db id null", order);
        System.out.println("Method");
    }
}
