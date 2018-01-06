package com.wat.pl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    public static Connection connect = null;


    public static void connect() throws Exception {
        if (connect == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/pzlog?" + "user=root&password=root");
        }
    }

    public static PreparedStatement getPreparedStatement(String sql)throws Exception {
        connect();

        return connect.prepareStatement(sql);
    }

//

}