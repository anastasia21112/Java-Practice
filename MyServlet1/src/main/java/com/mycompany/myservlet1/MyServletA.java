/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myservlet1;

/**
 *
 * @author AnastasiaDunca
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServletA extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String message = "If you're reading this, it worked!";

	out.println("<HTML><BODY>");
	out.println("<H1>" + message + "</H1>");
	out.println("</BODY></HTML>");
	out.close();
    }
}