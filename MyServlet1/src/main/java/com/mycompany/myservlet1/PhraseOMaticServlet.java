/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myservlet1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author AnastasiaDunca
 */
public class PhraseOMaticServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String title = "PhraseOMatic has generated the following phrase";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<HTML><HEAD><TITLE>");
        out.println("PhraseOMatic");
        out.println("</TITLE></HEAD><BODY>");
        out.println("<H1>" + title + "</H1>");
        out.println("<P>" + PhraseOMatic.makePhrase());
        out.println("<P><a href=\"PhraseOMaticServlet\" >make another phrase</a></p>");
        out.println("</BODY></HTML>");
        
        out.close();
        
        
    }
}