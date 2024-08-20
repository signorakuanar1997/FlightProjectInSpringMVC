<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Form</title>
<style>
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="datetime-local"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        button {
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
<h2>${flight.id == null ? 'Add New Flight' : 'Edit Flight'}</h2>
    <form action="/flights" method="post">
        <input type="hidden" name="id" value="${flight.id}">
        
        <label for="flightNumber">Flight Number:</label>
        <input type="text" id="flightNumber" name="flightNumber" value="${flight.flightNumber}">
        
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" value="${flight.destination}">
        
        <label for="departureTime">Departure Time:</label>
        <input type="datetime-local" id="departureTime" name="departureTime" value="${flight.departureTime}">
        
        <label for="arrivalTime">Arrival Time:</label>
        <input type="datetime-local" id="arrivalTime" name="arrivalTime" value="${flight.arrivalTime}">
        
        <button type="submit">Save</button>
    </form>
</body>
</html>