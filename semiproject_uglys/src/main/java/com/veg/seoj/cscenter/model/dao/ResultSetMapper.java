package com.veg.seoj.cscenter.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brief description of functions
 *
 * @author J
 * @version 2023-11-15
 */

public interface ResultSetMapper <T> {
    T fromResultSet(ResultSet rs) throws SQLException;

    class MapperUtil {
        public static <T> T mapResultSet(ResultSet rs, ResultSetMapper<T> mapper) throws SQLException {
            return mapper.fromResultSet(rs);
        }
    }
}