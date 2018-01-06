package com.wat.pl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class User {

    private static String getRandomString() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[32];
        random.nextBytes(bytes);


        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

//    private String getHash(String passwordToHash, String   salt){
//        String generatedPassword = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-512");
//            md.update(salt.getBytes("UTF-8"));
//            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++){
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            generatedPassword = sb.toString();
//        }
//        catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return generatedPassword;
//    }


    public static String Loggin(String login, String password) {
        try {
            PreparedStatement prStatement = MySQLAccess.getPreparedStatement("SELECT iduser FROM USER WHERE user=? AND password=?;");
            prStatement.setString(1, login);
            prStatement.setString(2, password);

            ResultSet resultSet = prStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            // TODO: generate user token
            String token = getRandomString();

            // TODO: Put token into database
            int iduser = resultSet.getInt("iduser");

            PreparedStatement tokenStatement = MySQLAccess.getPreparedStatement("Update user set token=? where user=?");
            tokenStatement.setString(1,token);
            tokenStatement.setInt(2, iduser);


            //TODO: Return token

            return token;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
