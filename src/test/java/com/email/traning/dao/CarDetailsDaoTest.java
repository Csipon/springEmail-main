package com.email.traning.dao;

import com.email.traning.domain.model.CarDetails;
import com.email.traning.domain.real.CarDetailsReal;
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
public class CarDetailsDaoTest {

    @Autowired
    private CarDetailsDao carDetailsDao;
    private Long carDetailsId;
    private CarDetails carDetails;

    @Before
    public void createCarDetails() {
        carDetails = new CarDetailsReal(200, "C-1", "2000", "disel", 20, "type", "leather", true, 2);
        carDetailsDao.create(carDetails);
        carDetailsId = carDetails.getId();
        assertNotNull("Car details id is null", carDetailsId);
        System.out.println("Car details with id " + carDetailsId + " added");
    }

    @After
    public void removeCarDetails() {
        assertNotNull("Car details not deleted", carDetailsDao.remove(carDetailsId));
        System.out.println("Removed");
    }

    @Test
    public void checkGetCarDetails() {
        CarDetails carDetails = carDetailsDao.getById(carDetailsId);
        assertNotNull("Car details from db id null", carDetails);
        System.out.println("Method");
    }

    @Test
    public void update() {
        carDetails.setSpeed(100);
        assertNotNull("Car details not updated", carDetailsDao.update(carDetails));
        System.out.println("Car details updated");
    }
}
