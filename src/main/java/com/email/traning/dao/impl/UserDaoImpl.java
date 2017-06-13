package com.email.traning.dao.impl;

import com.email.traning.dao.UserDao;
import com.email.traning.domain.model.User;
import com.email.traning.domain.model.UserRole;
import com.email.traning.domain.real.UserReal;
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

import static com.email.traning.dao.impl.sql.UserSqlQuery.*;

/**
 * Created by Smeet on 06.06.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    private SimpleJdbcInsert insert;
    private UserResultSetExtractor userResultSetExtractor;
    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName(PARAM_USER_TABLE)
                .usingGeneratedKeyColumns(PARAM_USER_ID);
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.userResultSetExtractor = new UserResultSetExtractor();
    }

    @Override
    public Long create(User object) {
        if (object.getId() != null){
            throw new ObjectExistException("User with id : " + object.getId() + " is exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_USER_FIRST_NAME, object.getFirstName())
                .addValue(PARAM_USER_LAST_NAME, object.getLastName())
                .addValue(PARAM_USER_EMAIL, object.getEmail())
                .addValue(PARAM_USER_PASSWORD, object.getPassword())
                .addValue(PARAM_USER_ROLE_ID, object.getUserRole().getId());

        Long id = insert.executeAndReturnKey(params).longValue();
        object.setId(id);
        return id;
    }

    @Override
    public Long remove(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_USER_ID, id);

        int rows = namedJdbcTemplate.update(SQL_DELETE_USER, params);
        if(rows > 0) {
            return id;
        }
        return null;
    }

    @Override
    public Long update(User object) {
        if (object.getId() == null){
            throw new ObjectExistException("User with id : " + object.getId() + " is not exist");
        }
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_USER_ID, object.getId())
                .addValue(PARAM_USER_FIRST_NAME, object.getFirstName())
                .addValue(PARAM_USER_LAST_NAME, object.getLastName())
                .addValue(PARAM_USER_EMAIL, object.getEmail())
                .addValue(PARAM_USER_PASSWORD, object.getPassword())
                .addValue(PARAM_USER_ROLE_ID, object.getUserRole().getId());
        int affectedRows = namedJdbcTemplate.update(SQL_USER_UPDATE, params);
        if (affectedRows > 0){
            return object.getId();
        }else {
            return null;
        }
    }

    @Override
    public User getById(Long id) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue(PARAM_USER_ID, id);
        List<User> users = namedJdbcTemplate.query(SQL_SELECT_USER_BY_ID, params, userResultSetExtractor);
        return users.stream().findFirst().orElse(null);
    }


    private static final class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

        @Override
        public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user = new UserReal();
                user.setId(rs.getLong(PARAM_USER_ID));
                user.setEmail(rs.getString(PARAM_USER_EMAIL));
                user.setPassword(rs.getString(PARAM_USER_PASSWORD));
                user.setFirstName(rs.getString(PARAM_USER_FIRST_NAME));
                user.setLastName(rs.getString(PARAM_USER_LAST_NAME));
                user.setUserRole(UserRole.valueOf(rs.getString(PARAM_USER_ROLE)));
                users.add(user);
            }
            return users;
        }
    }
}
