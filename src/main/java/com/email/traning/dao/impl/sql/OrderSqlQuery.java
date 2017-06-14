package com.email.traning.dao.impl.sql;

/**
 * Created by Smeet on 06.06.2017.
 */
public final class OrderSqlQuery {

    public static final String PARAM_ORDER_TABLE = "orders";
    public static final String PARAM_ORDER_ID = "id";
    public static final String PARAM_ORDER_DATE_RESERVATION = "date";
    public static final String PARAM_ORDER_DUE_DATE = "due_date";
    public static final String PARAM_ORDER_TOTAL_PRICE = "total_price";
    public static final String PARAM_ORDER_CAR_ID = "car_id";
    public static final String PARAM_ORDER_CUSTOMER_ID = "customer_id";
    public static final String PARAM_ORDER_MANAGER_ID = "manager_id";
    public static final String PARAM_ORDER_STATUS_ID = "statuses_id";

    public static final String PARAM_ORDER_STATUS = "status";

    public static final String SQL_SELECT_ORDER_BY_ID = "SELECT o.id, date, due_date, " +
            "total_price, car_id, customer_id, manager_id, statuses_id, s.status " +
            "FROM orders o " +
            "INNER JOIN statuses s " +
            "ON o.statuses_id = s.id " +
            "WHERE o.id = :id;";

    public static final String SQL_ORDER_UPDATE = "UPDATE orders " +
            "SET date = :date, due_date = :due_date, " +
            "total_price = :total_price, " +
            "car_id = :car_id, " +
            "customer_id = :customer_id, " +
            "manager_id = :manager_id, " +
            "statuses_id = :statuses_id " +
            "WHERE id = :id;";

    public static final String SQL_ORDER_DELETE = "DELETE FROM orders WHERE id = :id;";

}
