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

    public T getEntity(ResultSet rs,
                       Class<T> clazz) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T entity = clazz
                .getDeclaredConstructor()
                .newInstance();

        return (T)entity
                .getClass()
                .getMethod("fromResultSet", ResultSet.class)
                .invoke(entity, rs);
    }

    /*    이건 특정 필드 단일값에 대한 작업을 할 수 있는 메소드임*/
/*    private String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }*/

    /*    private T getDTO(T entity, ResultSet rs, String fieldName) {
            // 엔터티 클래스에 "fieldName"이라는 필드가 있다고 가정
    *//*        String fieldName = "fieldName"; // 실제 필드 이름으로 교체*//*
        try {
            // Reflection을 사용하여 필드의 getter 메소드 가져오기
            Method getterMethod = entity.getClass().getMethod("get" + capitalize(fieldName));

            // getter 메소드 호출하여 ResultSet에서 값을 가져오기
            // 예를들어 Student 객체라면 getStudent 객체를 가져오는거임.
            Object someDTO = getterMethod.invoke(entity);

            // DTO에 값을 설정하거나 필요한 로직 수행
            // 예를 들어, someDTO에 setFieldName이라는 setter 메소드가 있다면 다음과 같이 사용 가능:
            // someDTO.setFieldName((String) value);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // 예외 처리
        }

        return null; // 실제 반환 문으로 교체
    }*/
    @Override
    public T getById(Connection conn, T entity, String k, PK id) {

        PreparedStatement statement = null;
        ResultSet rs = null;
        T someDTO = null;
        try {
//            sql.notice.getById
            statement = conn.prepareStatement(sql.getProperty(k));
            statement.setInt(1, (int)id);
            rs = statement.executeQuery();

            // 여기서 field안에 해당 객체를 빌더하는 빌더 게터가 있거나, ////////////////////////////////
            // dao의 getdto내에 제네릭 타입에 따라 유동적으로 빌더 하는 패턴이 존재해야 함////////////////
/* 인터페이스를 상속받은 객체들로 해야 해서,
인터페이스를 하나 더 만들어서 프롬 리절트가 들어가야함 */
            if (rs.next()) {
                someDTO = (T)entity
                        .getClass()
                        .getMethod("fromResultSet", ResultSet.class)
                        .invoke(entity, rs);
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

   /* @Override
    public int delete(T entity,String k, Object... params) {

        PreparedStatement pstmt=null;
        int result=0;
        try {
            //"sql.notice.delete"
            pstmt=conn.prepareStatement(sql.getProperty(k));
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result=pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt);
        }
        return result;
    }*/

    @Override
    public List<T> getTo(Connection conn, T entity, String k, Object... params) {

        List<T> entities = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        T someDTO = null;

        try {
            //"sql.notice.getAll"
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
                        .getMethod("fromResultSet", ResultSet.class)
                        .invoke(entity, rs);

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
            // sql.notice.add
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
            // sql.notice.add
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
//    @Override
//    public int update(Connection conn,T entity,String k, Object... params){
//        PreparedStatement pstmt=null;
//        int result=0;
//        try {
//            // sql.notice.update
//            pstmt=conn.prepareStatement(sql.getProperty(k));
//            if(params.length > 0){
//            for (int i = 0; i < params.length; i++) {
//                pstmt.setObject(i + 1, params[i]);
//                }
//            }
//            result=pstmt.executeUpdate();
//
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }finally {
//            close(pstmt);
//        }
//        return result;
//    }

    ////// 서비스에
/*    public void exampleMethod(Object... args) {
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
    public static void main(String[] args) {
        exampleMethod("Hello", 42, 3.14, true);
    }*/

//// 서비스에
    /*    GenericDAOImpl dao=new GenericDAOImpl(conn,"notice");*/
/*    @Override
    public int delete(Connection conn,T entity,String k, Object... params) {
        PreparedStatement pstmt=null;
        int result=0;
        try {
            //"sql.notice.delete"
            pstmt=conn.prepareStatement(sql.getProperty(k));
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result=pstmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt);
        }
        return result;
    }*/

/*    private T mapResultSetToObject(ResultSet resultSet) throws SQLException {

    }*/

/*    public static void main(String[] args) throws SQLException {
        // 예제 실행
        Connection conn = getConnection();
        GenericDAOImpl<Notice, Integer> noticeDAO = new GenericDAOImpl<>(conn, "conn");

        ResultSet rs = null;
        *//*      Notice Some = (Notice)Notice.fromResultSet(rs);*//*
//        Notice n = new Notice();
        // 사용 예시
        Notice retrievedNotice = noticeDAO.getById(conn, Notice
                .builder()
                .build(), "sql.notice.getById", 1);
        List<Notice> allNotices = noticeDAO.getTo(conn, Notice
                .builder()
                .build(), "sql.notice.getAll");
        // ... 추가적인 사용 예시
    }*/
}