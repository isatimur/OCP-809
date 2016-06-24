package com.isatimur.ocp.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tisachenko on 09.05.16.
 */
public interface TResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
