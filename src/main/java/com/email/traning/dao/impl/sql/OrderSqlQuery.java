package com.email.traning.dao.impl.sql;

/**
 * Created by Smeet on 06.06.2017.
 */
public final class OrderSqlQuery {

    public static final String PARAM_ORDER_TABLE = "Orders";
    public static final String PARAM_ORDER_ID = "id";
    public static final String PARAM_ORDER_DATE_RESERVATION = "date";
    public static final String PARAM_ORDER_DUE_DATE = "due_date";
    public static final String PARAM_ORDER_TOTAL_PRICE = "total_price";
    public static final String PARAM_ORDER_CAR_ID = "car_id";
    public static final String PARAM_ORDER_USER_ID = "user_id";

    public static final String SQL_ORDER_SELECT_ALL = "SELECT id, date_reservation, " +
            "date_from, date_to, price, car_id, user_id FROM ORDERS";


}
