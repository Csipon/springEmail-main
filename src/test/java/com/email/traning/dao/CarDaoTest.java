package com.email.traning.dao;

import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.CarDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Smeet on 09.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarDaoTest {

    @Autowired
    private CarDao carDao;
    private Long idCar;

    @Before
    public void createCar() {
        Car car = new Car("Z-1", "Audi", 2006, 400D, new CarDetails());
        carDao.create(car);
        idCar = car.getId();
        assertNotNull("Car id is null", idCar);
        System.out.println("car with id " + idCar + " added");
        car.setModel("Z-2");
        carDao.update(car);
        System.out.println("car updated");
    }

    @After
    public void removeCar() {
        assertNotNull("Car not deleted", carDao.remove(idCar));
        System.out.println("removed");
    }

    @Test
    public void checkGetCar() {
        Car car = carDao.getById(idCar);
        assertNotNull("object from db is null", car);
        System.out.println("method");
    }

}
