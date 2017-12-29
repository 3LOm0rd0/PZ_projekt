package com.wat.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private static Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private static void connect() throws Exception {
        if (connect == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/pzlog?" + "user=root&password=root");
        }
    }

    public static Statement getStatement() throws Exception {
        connect();
        return connect.createStatement();

    }

    public static PreparedStatement getPreparedStatement(String sql)throws Exception {
        connect();

        return connect.prepareStatement(sql);
    }


    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

//            if (statement != null) {
//                statement.close();
//            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}