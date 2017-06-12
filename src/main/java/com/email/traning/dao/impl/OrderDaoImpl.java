package com.email.traning.dao.impl;

import com.email.traning.dao.CarDao;
import com.email.traning.dao.OrderDao;
import com.email.traning.dao.UserDao;
import com.email.traning.domain.model.Order;
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

import static com.email.traning.dao.impl.sql.OrderSqlQuery.*;

/**
 * Created by Smeet on 06.06.2017.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private OrderExtractor orderExtractor;

    @Autowired
    public OrderDaoImpl(DataSource dataSource, UserDao userDao, CarDao carDao) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(PARAM_ORDER_TABLE)
                .usingGeneratedKeyColumns(PARAM_ORDER_ID);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.orderExtractor = new OrderExtractor(userDao, carDao);

    }

    @Override
    public Long create(Order object) {
        if(object.getId() != null) {
            throw new ObjectExistException("Order with id : " + object.getId() + " is exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_ORDER_DATE_RESERVATION, object.getDate())
                .addValue(PARAM_ORDER_DUE_DATE, object.getDueDate())
                .addValue(PARAM_ORDER_TOTAL_PRICE, object.getTotalPrice())
                .addValue(PARAM_ORDER_CAR_ID, object.getCar().getId())
                .addValue(PARAM_ORDER_USER_ID, object.getUser().getId());
        long id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long remove(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_ORDER_ID, id);
        int rows = jdbcTemplate.update(SQL_ORDER_DELETE, params);
        if(rows > 0) {
            return id;
        }
        return null;
    }

    @Override
    public Long update(Order object) {
        if (object.getId() == null){
            throw new ObjectExistException("Order with id : " + object.getId() + " is not exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_ORDER_ID, object.getId())
                .addValue(PARAM_ORDER_DATE_RESERVATION, object.getDate())
                .addValue(PARAM_ORDER_DUE_DATE, object.getDueDate())
                .addValue(PARAM_ORDER_TOTAL_PRICE, object.getTotalPrice())
                .addValue(PARAM_ORDER_CAR_ID, object.getCar().getId())
                .addValue(PARAM_ORDER_USER_ID, object.getUser().getId());
        int affectedRows = jdbcTemplate.update(SQL_ORDER_UPDATE, params);
        if (affectedRows > 0){
            return object.getId();
        }else {
            return null;
        }
    }

    @Override
    public Order getById(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_ORDER_ID, id);
        List<Order> orders = jdbcTemplate.query(SQL_SELECT_ORDER_BY_ID, params, orderExtractor);
        return orders.stream().findFirst().orElse(null);
    }

    private static class OrderExtractor implements ResultSetExtractor<List<Order>> {

        private UserDao userDao;
        private CarDao carDao;

        @Autowired
        public OrderExtractor(UserDao userDao, CarDao carDao) {
            this.userDao = userDao;
            this.carDao = carDao;
        }

        @Override
        public List<Order> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Order> orders = new LinkedList<>();
            while(resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong(PARAM_ORDER_ID));
                order.setDate(resultSet.getTimestamp(PARAM_ORDER_DATE_RESERVATION).toLocalDateTime().toLocalDate());
                order.setDueDate(resultSet.getTimestamp(PARAM_ORDER_DUE_DATE).toLocalDateTime().toLocalDate());
                order.setTotalPrice(resultSet.getDouble(PARAM_ORDER_TOTAL_PRICE));
                order.setCar(carDao.getById(resultSet.getLong(PARAM_ORDER_CAR_ID)));
                order.setUser(userDao.getById(resultSet.getLong(PARAM_ORDER_USER_ID)));
                orders.add(order);
            }
            return orders;
        }
    }
}
