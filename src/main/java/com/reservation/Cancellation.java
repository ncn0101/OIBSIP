package com.reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Cancellation extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    String pnr = request.getParameter("pnr");

	    // JDBC Connection
	    try {
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
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String trainNumber = rs.getString("trainNumber");
                String trainName = rs.getString("trainName");
                String date = rs.getString("date");
                String from = rs.getString("from");
                String to = rs.getString("to");

                // Delete the reservation
                PreparedStatement cancelStmt = conn.prepareStatement("DELETE FROM reservation WHERE PNR=?");
                cancelStmt.setString(1, pnr);
                int rowsAffected = cancelStmt.executeUpdate();

                if (rowsAffected > 0) {
                    // Display cancellation message
                    out.println("<h2>Reservation with PNR " + pnr + " canceled successfully!</h2>");
                } else {
                    out.println("<h2>Error canceling reservation. Please try again.</h2>");
                }
            } else {
                out.println("<h2>No reservation found with PNR " + pnr + ".</h2>");
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}

