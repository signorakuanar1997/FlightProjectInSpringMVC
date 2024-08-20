<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
 <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>

</head>
<body>

    <h2>Flight List</h2>
    <a href="/flights/new">Add New Flight</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Flight Number</th>
                <th>Destination</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${flights}" var="flight">
                <tr>
                    <td>${flight.id}</td>
                    <td>${flight.flightNumber}</td>
                    <td>${flight.destination}</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalTime}</td>
                    <td>
                        <a href="/flights/edit/${flight.id}">Edit</a> |
                        <a href="/flights/delete/${flight.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>