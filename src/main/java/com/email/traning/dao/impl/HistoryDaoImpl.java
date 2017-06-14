package com.email.traning.dao.impl;

import com.email.traning.dao.HistoryDao;
import com.email.traning.dao.OrderDao;
import com.email.traning.domain.model.History;
import com.email.traning.domain.model.Order;
import com.email.traning.domain.model.Statuses;
import com.email.traning.domain.proxy.OrderProxy;
import com.email.traning.domain.real.HistoryReal;
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

import static com.email.traning.dao.impl.sql.HistorySqlQuery.*;

/**
 * Created by Smeet on 14.06.2017.
 */
@Repository
public class HistoryDaoImpl implements HistoryDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private HistoryExtractor historyExtractor;

    @Autowired
    public HistoryDaoImpl(DataSource dataSource, OrderDao orderDao) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(PARAM_HISTORY_TABLE)
                .usingGeneratedKeyColumns(PARAM_HISTORY_ID);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.historyExtractor = new HistoryExtractor(orderDao);
    }

    @Override
    public Long create(History object) {
        if(object.getId() != null) {
            throw new ObjectExistException("History with id : " + object.getId() + " already exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_HISTORY_DATE, object.getDate())
                .addValue(PARAM_HISTORY_DESCRIPTION, object.getDescription())
                .addValue(PARAM_HISTORY_STATUS_ID, object.getStatus().getId())
                .addValue(PARAM_HISTORY_ORDER, object.getOrder().getId());
        long id = jdbcInsert.executeAndReturnKey(params).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long remove(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_HISTORY_ID, id);
        int rows = jdbcTemplate.update(SQL_DELETE_FROM_HISTORY_BY_ID, params);
        if(rows > 0) {
            return id;
        }
        return null;
    }

    @Override
    public Long update(History object) {
        if(object.getId() == null) {
            throw new ObjectExistException("History with id " + object.getId() + " is not exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_HISTORY_ID, object.getId())
                .addValue(PARAM_HISTORY_DATE, object.getDate())
                .addValue(PARAM_HISTORY_DESCRIPTION, object.getDescription())
                .addValue(PARAM_HISTORY_STATUS_ID, object.getStatus().getId())
                .addValue(PARAM_HISTORY_ORDER, object.getOrder().getId());
        int rows = jdbcTemplate.update(SQL_UPDATE_HISTORY_BY_ID, params);
        if(rows > 0) {
            return object.getId();
        }
        return null;
    }

    @Override
    public History getById(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_HISTORY_ID, id);
        List<History> histories = jdbcTemplate.query(SQL_SELECT_HISTORY_BY_ID, params, historyExtractor);
        return histories.stream().findFirst().orElse(null);
    }


    private static class HistoryExtractor implements ResultSetExtractor<List<History>> {

        private OrderDao orderDao;

        @Autowired
        public HistoryExtractor(OrderDao orderDao) {
            this.orderDao = orderDao;
        }

        @Override
        public List<History> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<History> histories = new LinkedList<>();

            while (resultSet.next()) {
                History history = new HistoryReal();
                history.setId(resultSet.getLong(PARAM_HISTORY_ID));
                history.setDate(resultSet.getTimestamp(PARAM_HISTORY_DATE).toLocalDateTime().toLocalDate());
                history.setDescription(resultSet.getString(PARAM_HISTORY_DESCRIPTION));
                history.setStatus(Statuses.valueOf(resultSet.getString(PARAM_HISTORY_STATUS)));

                Order order = new OrderProxy(orderDao);
                order.setId((resultSet.getLong((PARAM_HISTORY_ORDER))));
                history.setOrder(order);

                histories.add(history);
            }
            return histories;
        }
    }
}
