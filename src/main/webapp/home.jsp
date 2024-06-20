<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 	<title>Online Reservation System</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
         }
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
            margin-top: 50px;
        }
        .container h1 {
            margin-bottom: 20px;
            color: #00796b;
        }
        .btn {
            display: block;
            width: 100%;
            margin: 10px 0;
            padding: 15px 0;
            font-size: 16px;
            color: #ffffff;
            background-color: #00796b;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
	 <div class="container">
        <h1>Online Reservation System</h1>
        <%
            String user = (String) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <a href="addReservation.jsp" class="btn">Add Reservation</a>
        <a href="cancelReservation.jsp" class="btn">Cancel Reservation</a>
    </div>
</body>
</html>