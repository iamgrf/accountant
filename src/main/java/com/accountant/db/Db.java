package com.accountant.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xy on 2017/11/9.
 */
public class Db {

    private static final String URL = "jdbc:sqlite:test.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    private static Integer insertOrDelete(String sql){
        Connection conn = null;
        try {
            conn = getConn();
            Statement statement = conn.createStatement();
            return statement.executeUpdate(sql);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Integer insert(String sql){
        return insertOrDelete(sql);
    }

    public static Integer insert(String sql, String ...args){
        Connection conn = null;
        try {
            conn = getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setString(i + 1, args[i]);
            }
            return preparedStatement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Integer delete(String sql){
        return insertOrDelete(sql);
    }

    public static List<Map<String, Object>> list(String sql){
        List<Map<String, Object>> data = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConn();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String[] metaData = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                metaData[i] = resultSetMetaData.getColumnName(i + 1);
            }
            while (resultSet.next()){
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < metaData.length; i++) {
                    map.put(metaData[i], resultSet.getString(metaData[i]));
                }
                data.add(map);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public static List<Map<String, Object>> list(String sql, String ...args){
        List<Map<String, Object>> data = new ArrayList<>();
        Connection conn = null;
        try {
            conn = getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setString(i + 1, args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            String[] metaData = new String[resultSetMetaData.getColumnCount()];
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                metaData[i] = resultSetMetaData.getColumnName(i + 1);
            }
            while (resultSet.next()){
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < metaData.length; i++) {
                    map.put(metaData[i], resultSet.getString(metaData[i]));
                }
                data.add(map);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

}
