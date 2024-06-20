<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <title>Reservation Form</title>
    <style>
 		body {
            background-image: url('neutral_background.jpg'); /* Replace 'neutral_background.jpg' with the path to your background image */
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #333; /* Text color */
        }

        h2 {
            color: #000; /* Heading color */
            text-align: center;
            margin-top: 50px;
        }

        form {
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background for the form */
            padding: 20px;
            border-radius: 10px;
            width: 400px;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"] {
            width: calc(100% - 10px);
            padding: 5px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #00796b; /* Button background color */
            color: #fff; /* Button text color */
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #004d40; /* Darker color on hover */
        }
    </style>
 </head>
<body>
	  <h2>Reservation Form</h2>
    <form action="Reservation" method="post">
        <table>
            <tr>
                <td><label for="firstName">First Name:</label></td>
                <td><input type="text" id="firstName" name="firstName" required></td>
            </tr>
            <tr>
                <td><label for="lastName">Last Name:</label></td>
                <td><input type="text" id="lastName" name="lastName" required></td>
            </tr>
            <tr>
                <td><label for="trainNumber">Train Number:</label></td>
                <td><input type="text" id="trainNumber" name="trainNumber" required></td>
            </tr>
            <tr>
                <td><label for="trainName">Train Name:</label></td>
                <td><input type="text" id="trainName" name="trainName" required></td>
            </tr>
            <tr>
                <td><label for="date">Date (YYYY-MM-DD):</label></td>
                <td><input type="text" id="date" name="date" required></td>
            </tr>
            <tr>
                <td><label for="from">From:</label></td>
                <td><input type="text" id="from" name="from" required></td>
            </tr>
            <tr>
                <td><label for="to">To:</label></td>
                <td><input type="text" id="to" name="to" required></td>
            </tr>
        </table>
        <button type="submit">Insert Reservation</button>
    </form>
</body>
</html>