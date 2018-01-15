package com.wat.pl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Symbol")
public class Symbol extends HttpServlet {

    public static boolean isApp6aCorrect(String app6aString){
        if(app6aString.length()!=15){

            return false;
        }

        System.out.println(app6aString.matches("^s[fhun][fgpsuz]p(.{6})[o-y\\-][d-k\\-](-{3})$"));
        return app6aString.matches("^s[fhun][fgpsuz]p(.{6})[o-y\\-][d-k\\-](-{3})$");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String symbol = request.getPathInfo();
        response.getWriter().println(symbol);

    }
}
