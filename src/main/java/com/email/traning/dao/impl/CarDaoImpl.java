package com.email.traning.dao.impl;

import com.email.traning.dao.CarDao;
import com.email.traning.dao.CarDetailsDao;
import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.CarDetails;
import com.email.traning.exception.ObjectExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.email.traning.dao.impl.sql.CarSqlQuery.*;

/**
 * Created by Smeet on 06.06.2017.
 */
@Repository
public class CarDaoImpl implements CarDao {

    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private CarResultSetExtractor carResultSetExtractor;
    private final CarDetailsDao carDetailsDao;
    private static final Logger logger = LogManager.getLogger("dao");

    @Autowired
    public CarDaoImpl(DataSource dataSource, CarDetailsDao carDetailsDao) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName(PARAM_CAR_TABLE)
                .usingGeneratedKeyColumns(PARAM_CAR_ID);
        this.carDetailsDao = carDetailsDao;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.carResultSetExtractor = new CarResultSetExtractor(carDetailsDao);
    }

    @Override
    public Long create(Car object) {
        if(object.getId() != null) {
            throw new ObjectExistException("Car with id : " + object.getId() + " is exist");
        }
        Long carDetailsId = getIdCarDetails(object.getCarDetails());
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_MARK, object.getMark())
                .addValue(PARAM_CAR_MODEL, object.getModel())
                .addValue(PARAM_CAR_PRICE_PER_HOUR, object.getPricePerHour())
                .addValue(PARAM_CAR_YEAR, object.getYear())
                .addValue(PARAM_CAR_DETAILS_ID, carDetailsId);
        Long id = insert.executeAndReturnKey(params).longValue();
        object.setId(id);
        logger.info("Car with id = " + id + " is successful created");
        return id;
    }

    private Long getIdCarDetails(CarDetails carDetails){
        if (carDetails.getId() == null){
            carDetailsDao.create(carDetails);
        }
        return carDetails.getId();
    }

    @Override
    public Long remove(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_ID, id);
        int rows = jdbcTemplate.update(SQL_DELETE_CAR_BY_ID, params);
        if(rows > 0) {
            logger.info("Car with id = " + id + " is successful deleted");
            return id;
        }
        logger.error("Car with id = " + id + " is not exist");
        return null;
    }

    @Override
    public Long update(Car object) {
        if(object.getId() == null) {
            logger.error("Car with id = " + object.getId() + " is not exist");
            throw new ObjectExistException("Car with id " + object.getId() + " is not exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_ID, object.getId())
                .addValue(PARAM_CAR_MODEL, object.getModel())
                .addValue(PARAM_CAR_MARK, object.getMark())
                .addValue(PARAM_CAR_YEAR, object.getYear())
                .addValue(PARAM_CAR_PRICE_PER_HOUR, object.getPricePerHour())
                .addValue(PARAM_CAR_DETAILS_ID, object.getCarDetails().getId());

        int rows = jdbcTemplate.update(SQL_UPDATE_CAR_BY_ID, params);
        if(rows > 0) {
            logger.info("Car with id = " + object.getId() + " is successful updated");
            return object.getId();
        }
        logger.error("Car with id = " + object.getId() + " not updated");
        return null;
    }

    @Override
    public Car getById(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_ID, id);
        List<Car> cars = jdbcTemplate.query(SQL_SELECT_CAR_BY_ID, params, carResultSetExtractor);
        logger.error("Car with id = " + id + " received");
        return cars.stream().findFirst().orElse(null);
    }

    private static final class CarResultSetExtractor implements ResultSetExtractor<List<Car>> {

        private CarDetailsDao carDetailsDao;

        CarResultSetExtractor(CarDetailsDao carDetailsDao) {
            this.carDetailsDao = carDetailsDao;
        }

        @Override
        public List<Car> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Car> cars = new LinkedList<>();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getLong(PARAM_CAR_ID));
                car.setMark(resultSet.getString(PARAM_CAR_MARK));
                car.setModel(resultSet.getString(PARAM_CAR_MODEL));
                car.setYear(resultSet.getInt(PARAM_CAR_YEAR));
                car.setPricePerHour(resultSet.getDouble(PARAM_CAR_PRICE_PER_HOUR));
                car.setCarDetails(carDetailsDao.getById(resultSet.getLong(PARAM_CAR_DETAILS_ID)));
                cars.add(car);
            }
            return cars;
        }
    }
}
