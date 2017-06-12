package com.email.traning.dao.impl;

import com.email.traning.dao.CarDetailsDao;
import com.email.traning.domain.model.CarDetails;
import com.email.traning.domain.model.User;
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
import java.util.Optional;

import static com.email.traning.dao.impl.sql.CarDetailsSqlQuery.*;

/**
 * Created by Smeet on 06.06.2017.
 */
@Repository
public class CarDetailsDaoImpl implements CarDetailsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private CarDetailsExtractor carDetailsExtractor;

    @Autowired
    public CarDetailsDaoImpl(DataSource dataSource) {
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
                .addValue(PARAM_CAR_DETAILS_CLASS, object.getClass())
                .addValue(PARAM_CAR_DETAILS_FUEL_CONSUME, object.getFuelConsume())
                .addValue(PARAM_CAR_DETAILS_FUEL_TYPE, object.getFuelType())
                .addValue(PARAM_CAR_DETAILS_POWER, object.getPower())
                .addValue(PARAM_CAR_DETAILS_SALON, object.getSalon())
                .addValue(PARAM_CAR_DETAILS_SPEED, object.getSpeed())
                .addValue(PARAM_CAR_DETAILS_TYPE, object.getType());
        Long id = jdbcInsert.executeAndReturnKey(params).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long remove(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_DETAILS_ID, id);
        int rows = jdbcTemplate.update(SQL_DELETE_CAR_DETAILS, params);
        if(rows > 0) {
            return id;
        }
        return null;
    }

    @Override
    public Long update(CarDetails object) {
        if(object.getId() == null) {
            throw new ObjectExistException("Car details with id " + object.getId() + " is not exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_DETAILS_ID, object.getId())
                .addValue(PARAM_CAR_DETAILS_SPEED, object.getSpeed())
                .addValue(PARAM_CAR_DETAILS_CLASS, object.getClassCar())
                .addValue(PARAM_CAR_DETAILS_POWER, object.getPower())
                .addValue(PARAM_CAR_DETAILS_FUEL_TYPE, object.getFuelType())
                .addValue(PARAM_CAR_DETAILS_FUEL_CONSUME, object.getFuelConsume())
                .addValue(PARAM_CAR_DETAILS_TYPE, object.getType())
                .addValue(PARAM_CAR_DETAILS_SALON, object.getSalon())
                .addValue(PARAM_CAR_DETAILS_TURBO, object.getTurbo())
                .addValue(PARAM_CAR_DETAILS_ACCELERATION, object.getAcceleration());
        int rows = jdbcTemplate.update(SQL_UPDATE_CAR_DETAILS, params);
        if(rows > 0) {
            return object.getId();
        }
        return null;
    }

    @Override
    public CarDetails getById(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_CAR_DETAILS_ID, id);
        List<CarDetails> carDetails = jdbcTemplate.query(SQL_SELECT_CAR_DETAILS_BY_ID, params, carDetailsExtractor);
        return carDetails.stream().findFirst().orElse(null);
    }

    private static class CarDetailsExtractor implements ResultSetExtractor<List<CarDetails>> {

        @Override
        public List<CarDetails> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<CarDetails> carDetails = new LinkedList<>();
            while(resultSet.next()) {
                CarDetails carDet = new CarDetails();
                carDet.setId(resultSet.getLong(PARAM_CAR_DETAILS_ID));
                carDet.setSpeed(resultSet.getInt(PARAM_CAR_DETAILS_SPEED));
                carDet.setAcceleration(resultSet.getInt(PARAM_CAR_DETAILS_ACCELERATION));
                carDet.setClassCar(resultSet.getString(PARAM_CAR_DETAILS_CLASS));
                carDet.setFuelConsume(resultSet.getInt(PARAM_CAR_DETAILS_FUEL_CONSUME));
                carDet.setFuelType(resultSet.getString(PARAM_CAR_DETAILS_FUEL_TYPE));
                carDet.setType(resultSet.getString(PARAM_CAR_DETAILS_TYPE));
                carDet.setSalon(resultSet.getString(PARAM_CAR_DETAILS_SALON));
                carDet.setPower(resultSet.getString(PARAM_CAR_DETAILS_POWER));
                carDet.setTurbo(resultSet.getBoolean(PARAM_CAR_DETAILS_TURBO));

                carDetails.add(carDet);
            }
            return carDetails;
        }
    }


}
