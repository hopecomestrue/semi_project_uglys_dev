package com.veg.seoj.cscenter.model.dao;

import com.veg.seoj.cscenter.model.dto.Notice;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.veg.common.JDBCTemplate.*;

public class GenericDAOImpl <T extends ResultSetMapper, PK> implements GenericDAO<T, PK> {
    private Properties sql = new Properties();

    {
        String path = GenericDAOImpl.class
                .getResource("/sql/cscenter/cscenter_sql.properties")
                .getPath();
        try (FileReader fr = new FileReader(path)) {
            sql.load(fr);
        } catch (IOException e) {
            printExceptionStack((IOException)e);
        }
    }

    private final String tableName;
    private Connection conn;

    public GenericDAOImpl(Connection conn, String tableName) {
        this.tableName = tableName;
        this.conn = conn;
    }

    @Override
    public T getById(Connection conn, T entity, String k, String type, PK id) {

        PreparedStatement statement = null;
        ResultSet rs = null;
        T someDTO = null;
        try {

            statement = conn.prepareStatement(sql.getProperty(k));
            statement.setInt(1, (int)id);
            rs = statement.executeQuery();

            if (rs.next()) {
                someDTO = (T)entity
                        .getClass()
                        .getMethod("fromResultSet", ResultSet.class, String.class)
                        .invoke(entity, rs, type);
            }
        } catch (SQLException e) {
            printExceptionStack((SQLException)e);
        } catch (InvocationTargetException e) {
            printExceptionStack((InvocationTargetException)e);
        } catch (IllegalAccessException e) {
            printExceptionStack((IllegalAccessException)e);
        } catch (NoSuchMethodException e) {
            printExceptionStack((NoSuchMethodException)e);
        } finally {
            close(rs);
            close(statement);
        }
        return someDTO;
    }


    @Override
    public List<T> getTo(Connection conn, T entity, String k, String type, Object... params) {

        List<T> entities = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        T someDTO = null;

        try {

            pstmt = conn.prepareStatement(sql.getProperty(k));
            if (params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                someDTO = (T)entity
                        .getClass()
                        .getMethod("fromResultSet", ResultSet.class, String.class)
                        .invoke(entity, rs, type);

                entities.add(someDTO);
            }
        } catch (SQLException e) {
            printExceptionStack((SQLException)e);
        } catch (InvocationTargetException e) {
            printExceptionStack((InvocationTargetException)e);
        } catch (IllegalAccessException e) {
            printExceptionStack((IllegalAccessException)e);
        } catch (NoSuchMethodException e) {
            printExceptionStack((NoSuchMethodException)e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return entities;
    }


    @Override
    public int addUpdateDelete(Connection conn, T entity, String k, Object... params) {
        PreparedStatement pstmt = null;
        int result = 0;
        try {

            pstmt = conn.prepareStatement(sql.getProperty(k));
            if (params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            printExceptionStack((SQLException)e);
        } finally {
            close(pstmt);
        }
        return result;
    }


    @Override
    public int count(Connection conn, T entity, String k) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        T someDTO = null;
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql.getProperty(k));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            printExceptionStack((SQLException)e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return result;
    }

    public void printExceptionStack(Exception exception) {
        exception.printStackTrace();
        Throwable cause = exception.getCause();
        if (cause != null) {
            System.out.println("원인 예외 메시지: " + cause.getMessage());
        } else {
            System.out.println("원인 없음");
        }
    }

}