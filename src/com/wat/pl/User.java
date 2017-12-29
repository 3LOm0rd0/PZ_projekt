package com.wat.pl;

import org.json.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class User {


    public static int Loggin(String login, String password) {
        try {
            PreparedStatement prStatement = MySQLAccess.getPreparedStatement("SELECT iduser FROM USER WHERE user=? AND password=?;");
            prStatement.setString(1, login);
            prStatement.setString(2, password);
            new JSONObject();
            ResultSet resultSet = prStatement.executeQuery();
            if (!resultSet.next()) {
                return -1;
            }

            return resultSet.getInt("iduser");

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }


    }
}
