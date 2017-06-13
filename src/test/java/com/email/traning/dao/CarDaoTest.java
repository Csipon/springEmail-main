package com.email.traning.dao;

import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.CarDetails;
import com.email.traning.domain.real.CarDetailsReal;
import com.email.traning.domain.real.CarReal;
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
        Car car = new CarReal("Z-1", "Audi", 2006, 400D, new CarDetailsReal(200, "C-1", "2000", "disel", 20, "type", "leather", true, 2));
        carDao.create(car);
        idCar = car.getId();
        assertNotNull("Car id is null", idCar);
        System.out.println("Car with id " + idCar + " added");
    }

    @After
    public void removeCar() {
        assertNotNull("Car not deleted", carDao.remove(idCar));
        System.out.println("Removed");
    }

    @Test
    public void checkGetCar() {
        Car car = carDao.getById(idCar);
        assertNotNull("Car from db is null", car);
        System.out.println("Method");
    }

    @Test
    public void update() {
        Car car = carDao.getById(idCar);
        car.setModel("Z-2");
        assertNotNull("Car not updated", carDao.update(car));
        System.out.println("Car updated");
    }




}
