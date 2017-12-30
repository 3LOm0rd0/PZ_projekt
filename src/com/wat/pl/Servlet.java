package com.wat.pl;

//import org.json.JSONObject;

import com.mysql.jdbc.PreparedStatement;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String userNameServlet = null;
    String passwordServlet = null;
    boolean access = false;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public Servlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //odczyt danych od klienta i zapis w postaci json
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonString = "";

        String line;
        StringBuilder jsonStringBuilder = new StringBuilder();
        if (br != null) {
            while ((line = br.readLine()) != null) {

                jsonStringBuilder.append(line);
                jsonStringBuilder.append('\r');
            }

            jsonString = jsonStringBuilder.toString();
            System.out.println(jsonString);
        }

        JSONObject json = JSONObject.fromObject(jsonString);
        String login = json.getString("login");
        String password = json.getString("pass");
        String token = User.Loggin(login, password);

        JSONObject jsonResponse = JSONObject.fromObject("{}");
        jsonResponse.put("token", token);

        //wyslanie danych do klienta jako json w stringu
        response.getWriter().println(jsonResponse.toString());

        /*komentarze w konsoli klienta *////////////////////////////////////////////
//        response.getWriter().println("Hello from servlet" );

        System.out.println("json.toString() : " + json.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        out.println(User.Loggin(login, password));
    }
}
