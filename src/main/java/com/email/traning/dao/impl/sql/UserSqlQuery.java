package com.email.traning.dao.impl.sql;

/**
 * Created by Smeet on 06.06.2017.
 */
public final class UserSqlQuery {
    public static final String PARAM_USER_TABLE = "Users";
    public static final String PARAM_USER_ID = "id";
    public static final String PARAM_USER_FIRST_NAME = "first_name";
    public static final String PARAM_USER_LAST_NAME = "last_name";
    public static final String PARAM_USER_EMAIL = "email";
    public static final String PARAM_USER_PASSWORD = "password";
    public static final String PARAM_USER_ROLE_ID = "user_roles_id";

    public static final String PARAM_USER_ROLE = "role";

    public static final String SQL_SELECT_USER_BY_ID = "SELECT id, email, " +
            "password, first_name, last_name, user_roles_id " +
            " FROM Users WHERE id = :id";

    public static final String SQL_USER_BY_EMAIL = "SELECT u.id, email, password, " +
            "first_name, last_name user_roles_id, r.role" +
            "FROM Users u " +
            "INNER JOIN User_roles r " +
            "ON u.user_roles_id = r.id " +
            "WHERE email = :email;";

}
