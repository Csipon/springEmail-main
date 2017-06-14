package com.email.traning.dao;

import com.email.traning.domain.model.*;
import com.email.traning.domain.real.CarDetailsReal;
import com.email.traning.domain.real.CarReal;
import com.email.traning.domain.real.OrderReal;
import com.email.traning.domain.real.UserReal;
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
    private OrderDao orderDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private UserDao userDao;
    private User customer;
    private User manager;
    private Car car;
    private Long orderId;


    @Before
    public void createOrder() {
        customer = new UserReal("Andrii", "Smetanko", "Andryuha@gmail.com", "123123", UserRole.ROLE_USER);
        manager = new UserReal("AndriiManger", "Smetanko", "Andryuha@gmail.com", "123123", UserRole.ROLE_USER);
        userDao.create(customer);
        userDao.create(manager);
        CarDetails carDetails = new CarDetailsReal(200, "C-1", "2000", "disel", 20, "Sedan", "leather", true, 5);
        car = new CarReal("Z-1", "Audi", 2006, 400D, carDetails, Statuses.ACTIVE);
        carDao.create(car);


        Order order = new OrderReal(LocalDate.now(), LocalDate.now(), 500D, Statuses.RESERVED, car, customer , manager);
        orderDao.create(order);
        orderId = order.getId();
        assertNotNull("Order id is null", orderId);
        System.out.println("Order with id " + orderId + " added");
    }

    @After
    public void removeOrder() {
        assertNotNull("Order not deleted", orderDao.remove(orderId));
        carDao.remove(car.getId());
        userDao.remove(customer.getId());
        System.out.println("Removed");
    }


    @Test
    public void checkGetOrder() {
        Order order = orderDao.getById(orderId);
        assertNotNull("Object from db id null", order);
        System.out.println("Method");
    }

    @Test
    public void update() {
        Order order = orderDao.getById(orderId);
        order.setTotalPrice(600D);
        assertNotNull("Order not updated", orderDao.update(order));
        System.out.println("Order updated");
    }
}
