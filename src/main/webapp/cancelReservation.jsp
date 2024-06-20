<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Cancel Reservation</title>
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
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
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
 	<body>
<div class="container">
    <h2>Cancel Reservation</h2>
    <form action="FetchReservationDetails" method="post">
        <label for="pnr">PNR Number:</label>
        <input type="text" id="pnr" name="pnr" required>
        <button type="submit">Fetch Details</button>
    </form>
</div>
</body>
</html>