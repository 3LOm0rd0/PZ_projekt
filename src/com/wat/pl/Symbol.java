package com.wat.pl;

import net.sf.json.JSONObject;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.SAXEngine;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "Symbol")
public class Symbol extends HttpServlet {
    public static String affiliation;
    public static String mobility;
    public static String rank;
    public static String type;

//    public static boolean isApp6aCorrect(String app6aString){
//        if(app6aString.length()!=15){
//
//            return false;
//        }
//
//        System.out.println(app6aString.matches("^s[fhun][fgpsuz]p(.{6})[o-y\\-][d-k\\-](-{3})$"));
//        return app6aString.matches("^s[fhun][fgpsuz]p(.{6})[o-y\\-][d-k\\-](-{3})$");
//
//    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        affiliation =(String) json.get("affiliation");
         mobility =(String)json.get("mobility");
         rank =(String)json.get("rank");
         type =(String)json.get(" type");


         String s= XMLParse.getParsed();
         System.out.println(s);
        response.getWriter().println(s);


    }

}