package com.email.traning.dao.impl.sql;

/**
 * Created by Smeet on 14.06.2017.
 */
public final class HistorySqlQuery {
    public static final String PARAM_HISTORY_TABLE = "history";
    public static final String PARAM_HISTORY_ID = "id";
    public static final String PARAM_HISTORY_DATE = "date";
    public static final String PARAM_HISTORY_DESCRIPTION = "description";
    public static final String PARAM_HISTORY_ORDER = "orders_id";
    public static final String PARAM_HISTORY_STATUS_ID = "change_statuses_id";

    public static final String PARAM_HISTORY_STATUS = "status";


    public static final String SQL_SELECT_HISTORY_BY_ID = "SELECT h.id, " +
            "date, description, orders_id, change_statuses_id, status  " +
            "FROM history h " +
            "INNER JOIN statuses s " +
            "ON h.change_statuses_id = s.id " +
            "WHERE h.id = :id;";

    public static final String SQL_DELETE_FROM_HISTORY_BY_ID = "DELETE FROM history " +
            "WHERE id = :id;";

    public static final String SQL_UPDATE_HISTORY_BY_ID = "UPDATE history " +
            "SET date = :date, description = :description, orders_id = :orders_id, " +
            "change_statuses_id = :change_statuses_id " +
            "WHERE id = :id;";
}
