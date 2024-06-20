package com.reservation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
 
public class Login extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String htmlFilePath = getServletContext().getRealPath("/login.html");

 	        try (BufferedReader reader = new BufferedReader(new FileReader(htmlFilePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                out.println(line);
	            }
	        } catch (FileNotFoundException e) {
 	            e.printStackTrace();
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // JDBC Connection
	        Connection conn = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/online_reservation";
	            String dbUsername = "root";
	            String dbPassword = "navya";
	            conn = DriverManager.getConnection(url, dbUsername, dbPassword);

	            pst = conn.prepareStatement("SELECT username FROM users WHERE username = ? AND password = ?");
	            pst.setString(1, username);
	            pst.setString(2, password);
	            rs = pst.executeQuery();

	            if (rs.next()) {
	                HttpSession session = request.getSession();
	                session.setAttribute("user", username);
	                response.sendRedirect("home.jsp");
	            } else {
	            	 request.setAttribute("error", "Invalid username or password");
	                 request.getRequestDispatcher("login.jsp").forward(request, response);
	            }

	        } catch (ClassNotFoundException e) {
	            out.println("Error: MySQL JDBC Driver not found.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            out.println("Error: Unable to connect to the database.");
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (rs != null) rs.close();
	                if (pst != null) pst.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
}
