package com.email.traning.dao.impl.sql;

/**
 * Created by Smeet on 06.06.2017.
 */
public final class CarSqlQuery {

    public static final String PARAM_CAR_TABLE = "cars";
    public static final String PARAM_CAR_ID = "id";
    public static final String PARAM_CAR_MODEL = "model";
    public static final String PARAM_CAR_MARK = "mark";
    public static final String PARAM_CAR_YEAR = "year";
    public static final String PARAM_CAR_PRICE_PER_HOUR = "price_per_hour";
    public static final String PARAM_CAR_DETAILS_ID = "car_details_id";
    public static final String PARAM_CAR_STATUS_ID = "statuses_id";

    public static final String PARAM_CAR_STATUS = "status";

    public static final String SQL_DELETE_CAR_BY_ID = "DELETE FROM cars WHERE id = :id;";

    public static final String SQL_UPDATE_CAR_BY_ID = "UPDATE cars " +
            "SET model = :model, mark = :mark, " +
            "year = :year, price_per_hour = :price_per_hour, " +
            "car_details_id = :car_details_id, statuses_id = :statuses_id " +
            "WHERE id = :id;";

    public static final String SQL_SELECT_CAR_BY_ID = "SELECT c.id, model, mark, " +
            "year, price_per_hour, car_details_id, c.statuses_id, s.status " +
            "FROM cars c " +
            "INNER JOIN statuses s " +
            "ON c.statuses_id = s.id " +
            "WHERE c.id = :id;";

}
