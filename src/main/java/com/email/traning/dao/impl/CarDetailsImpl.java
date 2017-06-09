package com.email.traning.dao.impl;

import com.email.traning.dao.CarDetailsDao;
import com.email.traning.domain.model.Car;
import com.email.traning.domain.model.CarDetails;
import com.email.traning.exception.ObjectExistException;
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

import static com.email.traning.dao.impl.sql.CarDetailsSqlQuery.*;

/**
 * Created by Smeet on 06.06.2017.
 */
@Repository
public class CarDetailsImpl implements CarDetailsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private CarDetailsExtractor carDetailsExtractor;

    @Autowired
    public CarDetailsImpl(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(PARAM_CAR_DETAILS_TABLE)
                .usingGeneratedKeyColumns(PARAM_CAR_DETAILS_ID);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.carDetailsExtractor = new CarDetailsExtractor();
    }

    @Override
    public Long create(CarDetails object) {
        if(object.getId() != null) {
            throw new ObjectExistException("Car details with id " + object.getId() + " already exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_DETAILS_ACCELERATION, object.getAcceleration())
                .addValue(PARAM_CAR_DETAILS_TURBO, object.getTurbo())
                .addValue(PARAM_CAR_DETALS_CLASS, object.getClass())
                .addValue(PARAM_CAR_DETALS_FUEL_CONSUME, object.getFuelConsume())
                .addValue(PARAM_CAR_DETALS_FUEL_TYPE, object.getFuelType())
                .addValue(PARAM_CAR_DETALS_POWER, object.getPower())
                .addValue(PARAM_CAR_DETALS_SALON, object.getSalon())
                .addValue(PARAM_CAR_DETALS_SPEED, object.getSpeed())
                .addValue(PARAM_CAR_DETALS_TYPE, object.getType());
        long id = jdbcInsert.executeAndReturnKey(params).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    @Override
    public Long update(CarDetails object) {
        if(object.getId() == null) {
            throw new ObjectExistException("Car details with id " + object.getId() + " is not exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_DETAILS_ID, object.getId())
                .addValue(PARAM_CAR_DETAILS_TURBO, object.getType())
                .addValue(PARAM_CAR_DETALS_TYPE, object.getType())
                .addValue(PARAM_CAR_DETALS_SPEED, object.getSpeed())
                .addValue(PARAM_CAR_DETALS_SALON, object.getSalon())
                .addValue(PARAM_CAR_DETALS_POWER, object.getPower())
                .addValue(PARAM_CAR_DETALS_FUEL_TYPE, object.getFuelType())
                .addValue(PARAM_CAR_DETALS_FUEL_CONSUME, object.getFuelConsume())
                .addValue(PARAM_CAR_DETALS_CLASS, object.getClass())
                .addValue(PARAM_CAR_DETAILS_ACCELERATION, object.getAcceleration());
        int affectedRows = jdbcTemplate.update(SQL_UPDATE_CAR_DETAILS_BY_ID, params);
        if(affectedRows > 0) {
            return object.getId();
        }
        return null;
    }

    @Override
    public CarDetails getById(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_DETAILS_ID, id);
        List<CarDetails> carDetails = jdbcTemplate.query(SQL_SELECT_CAR_DETAILS_BY_ID, params, carDetailsExtractor);
        return carDetails.stream().findFirst().get();
    }

    private static class CarDetailsExtractor implements ResultSetExtractor<List<CarDetails>> {

        @Override
        public List<CarDetails> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<CarDetails> carDetails = new LinkedList<>();
            while(resultSet.next()) {
                CarDetails carDet = new CarDetails();
                carDet.setId(resultSet.getLong(PARAM_CAR_DETAILS_ID));
                carDet.setSpeed(resultSet.getInt(PARAM_CAR_DETALS_SPEED));
                carDet.setAcceleration(resultSet.getInt(PARAM_CAR_DETAILS_ACCELERATION));
                carDet.setClassCar(resultSet.getString(PARAM_CAR_DETALS_CLASS));
                carDet.setFuelConsume(resultSet.getInt(PARAM_CAR_DETALS_FUEL_CONSUME));
                carDet.setFuelType(resultSet.getString(PARAM_CAR_DETALS_FUEL_TYPE));
                carDet.setType(resultSet.getString(PARAM_CAR_DETALS_TYPE));
                carDet.setSalon(resultSet.getString(PARAM_CAR_DETALS_SALON));
                carDet.setPower(resultSet.getString(PARAM_CAR_DETALS_POWER));
                carDet.setTurbo(resultSet.getString(PARAM_CAR_DETAILS_TURBO).charAt(0));

                carDetails.add(carDet);
            }
            return carDetails;
        }
    }


}
