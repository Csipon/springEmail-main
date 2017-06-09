package com.email.traning.dao.impl.sql;

/**
 * Created by Smeet on 06.06.2017.
 */
public final class CarDetailsSqlQuery {

    public static final String PARAM_CAR_DETAILS_TABLE = "car_details";
    public static final String PARAM_CAR_DETAILS_ID = "id";
    public static final String PARAM_CAR_DETALS_SPEED = "speed";
    public static final String PARAM_CAR_DETALS_CLASS = "class";
    public static final String PARAM_CAR_DETALS_POWER = "power";
    public static final String PARAM_CAR_DETALS_FUEL_TYPE = "fuel_type";
    public static final String PARAM_CAR_DETALS_FUEL_CONSUME = "fuel_consume";
    public static final String PARAM_CAR_DETALS_TYPE = "type";
    public static final String PARAM_CAR_DETALS_SALON = "salon";
    public static final String PARAM_CAR_DETAILS_TURBO = "turbo";
    public static final String PARAM_CAR_DETAILS_ACCELERATION = "acceleration";

    public static final String SQL_SELECT_CAR_DETAILS_BY_ID = "SELECT id, speed, class, " +
            "power, fuel_type, fuel_consume, type, salon, turbo, acceleration " +
            "FROM car_details " +
            "WHERE id = :id;";

    public static final String SQL_UPDATE_CAR_DETAILS_BY_ID = "UPDATE car_details " +
            "SET speed = :speed, class = :class, " +
            "power = :power, fuel_type = :fuel_type, fuel_consume = :fuel_consume, " +
            "type = :type, salon = :salon, turbo = :turbo, acceleration = :acceleration, " +
            "WHERE id = :id;";

}
