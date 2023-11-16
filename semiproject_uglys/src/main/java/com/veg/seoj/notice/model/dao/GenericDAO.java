package com.veg.seoj.notice.model.dao;

import java.sql.Connection;
import java.util.List;

/**
 * Brief description of functions
 *
 * @author J
 * @version 2023-11-14
 */
public interface GenericDAO <T, PK>{
    T getById(Connection conn,T entity, String k, PK id);
    List<T> getTo(Connection conn, T entity, String k,Object... params);
    int addUpdateDelete(Connection conn,T entity, String k, Object... params);
    int count(Connection conn,T entity, String k);
//    int update(Connection conn,T entity,String k, Object... params);
/*    int delete(Connection conn,T entity,String k,Object... params);*/
}