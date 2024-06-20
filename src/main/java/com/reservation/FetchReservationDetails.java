package com.reservation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class FetchReservationDetails extends HttpServlet {
	 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("cancelReservation.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        String pnr = request.getParameter("pnr");

	        try {
	            // JDBC Connection
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/online_reservation";
	            String username = "root";
	            String password = "navya";
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Check if the reservation exists
	            PreparedStatement pst = conn.prepareStatement("SELECT * FROM reservation WHERE PNR=?");
	            pst.setString(1, pnr);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                // Store reservation details
	                request.setAttribute("pnr", pnr);
	                request.setAttribute("firstName", rs.getString("firstName"));
	                request.setAttribute("lastName", rs.getString("lastName"));
	                request.setAttribute("trainNumber", rs.getString("trainNumber"));
	                request.setAttribute("trainName", rs.getString("trainName"));
	                request.setAttribute("date", rs.getString("date"));
	                request.setAttribute("from", rs.getString("from"));
	                request.setAttribute("to", rs.getString("to"));

	                // Forward to confirmation JSP
	                RequestDispatcher dispatcher = request.getRequestDispatcher("confirmCancellation.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                request.setAttribute("message", "No reservation found with PNR " + pnr + ".");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservation.jsp");
	                dispatcher.forward(request, response);
	            }

	            conn.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            request.setAttribute("message", "Error: " + e.getMessage());
	            RequestDispatcher dispatcher = request.getRequestDispatcher("cancelReservation.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
	

}
