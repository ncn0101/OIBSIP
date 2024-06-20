package com.reservation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

 
public class Reservation extends HttpServlet {
	 PreparedStatement statement = null;
	 Connection conn = null;
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<h2>This servlet only handles POST requests. Please submit the form to make a reservation.</h2>");
	    }
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    String firstName = request.getParameter("firstName");
		    String lastName = request.getParameter("lastName");
		    String trainNumber = request.getParameter("trainNumber");
		    String trainName = request.getParameter("trainName");
		    String date = request.getParameter("date");
		    String from = request.getParameter("from");
		    String to = request.getParameter("to");

		    
		    try {
 		        Class.forName("com.mysql.cj.jdbc.Driver");
		        String url = "jdbc:mysql://localhost:3306/online_reservation";
		        String username = "root";
		        String password = "navya";
		        conn = DriverManager.getConnection(url, username, password);

 		        int pnrNumber = getNextPNRNumberFromDatabase(); // Implement this method to retrieve the next available PNR number
		        String pnr = "PNR" + pnrNumber;

 		        String sql = "INSERT INTO reservation (`PNR`, `firstName`,`lastName`,`trainNumber`,`trainName`,`date`,"
		        		+ "`from`,`to`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		          statement = conn.prepareStatement(sql);
		        statement.setString(1, pnr);
		        statement.setString(2, firstName);
		        statement.setString(3, lastName);
		        statement.setString(4, trainNumber);
		        statement.setString(5, trainName);
		        statement.setString(6, date);
		        statement.setString(7, from);
		        statement.setString(8, to);

		        // Execute the statement
		        int rowsInserted = statement.executeUpdate();
		        if (rowsInserted > 0) {
		            out.println("<h2>Reservation inserted successfully! note the pnr for easy canellation : PNR: " + pnr + "</h2>");
		        }
		    } catch (ClassNotFoundException | SQLException ex) {
		        out.println("Error: " + ex.getMessage());
		    } finally {
		        if (conn != null) {
		            try {
		                conn.close();
		            } catch (SQLException e) {
		                out.println("Error closing database connection: " + e.getMessage());
		            }
		        }
		    }
		}

	  public int getNextPNRNumberFromDatabase() {
		  int nextPNRNumber = 0;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
 	            String sql = "SELECT MAX(SUBSTRING(PNR, 4)) AS max_pnr FROM reservation";
	            try {
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
				} catch (SQLException e) {
 					e.printStackTrace();
				}
	            
	            try {
					if (rs.next()) {
					    String maxPNR = rs.getString("max_pnr");
					    if (maxPNR != null) {
					        nextPNRNumber = Integer.parseInt(maxPNR) + 1;
					    } else {
 					        nextPNRNumber = 1;
					    }
					}
				} catch (NumberFormatException e) {
 					e.printStackTrace();
				} catch (SQLException e) {
 					e.printStackTrace();
				}
	        } finally {
	         
	            if (rs != null)
					try {
						rs.close();
	            if (stmt != null)
						stmt.close();
					} catch (SQLException e) {
				
						e.printStackTrace();
					}
	        }

	        return nextPNRNumber;
	}

}