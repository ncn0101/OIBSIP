<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Cancellation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 400px;
        width: 100%;
    }
    h2 {
        margin-top: 0;
        color: #333;
        text-align: center;
        margin-bottom: 20px;
    }
    form {
        text-align: center;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #00796b;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #004d40;
    }
</style>
  </head>
  
<body>
<div class="container">
    <h2>Confirm Cancellation</h2>
    <h3>Details of the Reservation:</h3>
    <p>First Name: <%= request.getAttribute("firstName") %></p>
    <p>Last Name: <%= request.getAttribute("lastName") %></p>
    <p>Train Number: <%= request.getAttribute("trainNumber") %></p>
    <p>Train Name: <%= request.getAttribute("trainName") %></p>
    <p>Date: <%= request.getAttribute("date") %></p>
    <p>From: <%= request.getAttribute("from") %></p>
    <p>To: <%= request.getAttribute("to") %></p>
    
    <form action="Cancellation" method="post">
        <input type="hidden" name="pnr" value="<%= request.getAttribute("pnr") %>">
        <button type="submit">Confirm Cancellation</button>
    </form>
</div>
</body>
</html>